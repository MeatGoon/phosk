<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	.branchHeader{
		border: 1px solid red;
	}
</style>
<title>Branch login Page</title>
</head>
<body>
	<header>
		<jsp:include page="../../onerHeader.jsp"/>
	</header>
	<div class="content">
		<form id="branchLoginForm" method="post" action="/branch/login/result">
			<label for="oner_id">점주 아이디 : </label><input type="text" name="oner_id" maxlength="20"/>
			<label for="oner_pwd">점주 패스워드 : </label><input type="text" name="oner_pwd" maxlength="20" onkeyup="enterkey();"/><br/>
			<input type="checkbox" id="id_save"><label>ID 기억하기</label>
			<button id="login">LOGIN</button>
			<button type="button" onclick="location.href='/branch/join/index'">REGISTER</button>
		</form>
	</div>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<script type="text/javascript">
window.onload = function loadcookie() {
	var branchLoginForm = $("#branchLoginForm");
	//'cookie' key값을 불러온다. 
	var cookie_value = $.cookie('oner_id');
	console.log("cookie = "+cookie_value);
	// load라는 id text태그에 cookie_value변수에 들어있는 값을 담는다. 
	if(cookie_value != null){
		branchLoginForm.find("input[name='oner_id']").val(cookie_value);
		$("#id_save").attr("checked",true);
	}
};
</script>
<script type="text/javascript">
	$(document).ready(function() {
		
		var result = '<c:out value="${result}"/>';
		var executions = '<c:out value="${executions}"/>';
		checkMessage(result,executions);
		//뭔가 작업후 이전페이지 갈때 반복안되게..예 : 등록후 이전페이지 클릭시 도배되는 문제를 막음.
		history.replaceState({},null,null);
		
		function checkMessage(result , executions) {
			if(result === '' || history.state){
				return;			
			}else if (result == 'success'){
				alert(executions + "를(을) 성공 하였습니다.");		
			}else{
				alert(executions + "를(을) 실패 하였습니다.");
			}
		}
		
		
		errCodeCheck();
		
		var branchLoginForm = $("#branchLoginForm");
		
		$("#login").on("click", function(e) {
			e.preventDefault();
			if(!formCheck(branchLoginForm.find("input[name='oner_id']"),"아이디를" )){
				return;
			}
			if(!formCheck(branchLoginForm.find("input[name='oner_pwd']"),"비밀번호를" )){
				return;
			}
			
			//id 기억하기 
			if ($("#id_save").is(":checked")) {
				$.removeCookie("oner_id",{path:'/'});
				//입력값
				var cookie_value = branchLoginForm.find("input[name='oner_id']").val();
				//'cookie'라는 key값으로 입력값을 저장한다. 
				//1번째 parameter = 쿠키명 
				// 2번째 parameter = 저장하고자 하는 쿠키값 
				$.cookie('oner_id', cookie_value, {expires:365, path:'/'});
			} else {
				$.removeCookie("oner_id",{path:'/'});
			}//id 기억하기 끝
			
			branchLoginForm.submit();
		});
		//console.log(${errCode});
	});
	//엔터키 함수
	function enterkey() {
		var branchLoginForm = $("#branchLoginForm");
		if (window.event.keyCode == 13) {
			branchLoginForm.submit();
		}
	}
	
	//form 관련 입력내용 누락 확인
	function formCheck(main, msg) {
		if (main.val().replace(/\s/g, "") == "") {
			alert(msg+" 입력해주세요.");
			main.val("");
			return false;
		} else {
			return true;
		}
	}
	
	
	//에러코드에 맞는 알림창띄움
	//나중에 commons.js 파일로 옮길예정.
	function errCodeCheck() {
		var errCode = '<c:out value="${errCode}" />';
		//asd
		if (errCode != "") {
			// 명확한 자료형 명시를 위해 errCode의 타입을 정수형으로 변환.
			switch (parseInt(errCode)) {
			case 1:
				alert('Password does not match or does not exist.\nPlease log in again.');
				break;
			}
		}
	}

</script>


</body>
</html>