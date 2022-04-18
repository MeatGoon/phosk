<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 지금 작성하는부분은 한참뒤이기에 대충 하고 넘어가겠음 -->
	<form action="/user/login/result" method="post" id="loginForm">
		<label for="member_id">아이디 : </label><input type="text" name="member_id"><br/>
		<label for="member_pwd">비밀번호 : </label><input type="password" name="member_pwd"><br/>
		<input type="button" value="login" id="loginSubmitBtn">
	</form>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var memberIdFlag = false;
	var memberPwdFlag = false;
	var loginForm = $("#loginForm");
	var memberId = loginForm.find("input[name='member_id']");	
	var memberPwd = loginForm.find("input[name='member_pwd']");
	
	$(memberId).blur(function() {
		if(checkInputData("아이디를 입력하세요." , memberId, memberIdFlag)){
			memberIdFlag = true;
		}else{
			memberIdFlag = false;
		}
	});
	
	$(memberPwd).blur(function() {
		if(checkInputData("비밀번호를 입력하세요." , memberPwd, memberPwdFlag)){
			memberPwdFlag = true;
		}else{
			memberPwdFlag = false;
		}
	});
	
	$("#loginSubmitBtn").on("click" , function(e) {
		e.preventDefault();
		checkInputData("아이디를 입력하세요." , memberId, memberIdFlag);
		checkInputData("비밀번호를 입력하세요." , memberPwd, memberPwdFlag);
		
		if(memberIdFlag != false && memberPwdFlag != false){
			loginForm.submit();
		}
	});
	//errCodeCheck();
	
});

function checkInputData(text,data,status) {
	if(data.val() == "" || data.val() == null){
		data.next().remove();
		data.after("<p style='color:red'>"+text+"</p>");
		return false;
	}
	console.log(status);
	if(status != true){
		data.next().remove();
		data.after("<br/>");
	}
	return true;
}

function enterkey() {
	let loginForm = $("#loginForm");
	if (window.event.keyCode == 13) {
		loginForm.submit();
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
</html>
