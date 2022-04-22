<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>branch Join index</title>
</head>
<header>
		<jsp:include page="../../onerHeader.jsp"/>
</header>
<body>
	<div class="formDiv">
		<form id="joinForm">
			<label for="oner_id">ID : </label><input type="text" name="oner_id" maxlength="20"/><button id="idCheck" type="button">IDCHECK</button><br/>
			
			<label for="oner_pwd">PASSWORD : </label><input type="password" name="oner_pwd" maxlength="20"/><br/>
			
			<label for="oner_email_first">EMAIL : </label><input type="text" name="oner_email_first" maxlength="20"/>@
			<select id="oner_email_second">
				<option value="N" selected>선택하세요</option>
				<option value="direct">직접입력</option>
			</select>
			<input type="text" name="oner_email_second_input" maxlength="20"/><br/>
			<input type="hidden" name="oner_email"/>
			
			<label for="oner_phone">PHONE : </label><input type="text" name="oner_phone" id="phoneNum"  maxlength="13"><br/>
			
			<button id="join">가입</button>
			<button type="reset">재입력</button>
			<button id="cancel">취소</button>
		</form>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		var joinForm = $("#joinForm");
		var oner_id = joinForm.find("input[name='oner_id']");
		var oner_pwd = joinForm.find("input[name='oner_pwd']");
		var oner_email = joinForm.find("input[name='oner_email']");
		var oner_email_first = joinForm.find("input[name='oner_email_first']");
		var oner_email_second = $("#oner_email_second");
		var oner_email_second_input = joinForm.find("input[name='oner_email_second_input']");
		var oner_phone = joinForm.find("input[name='oner_phone']");
		var id_check_flag = false;//아이디 체크
		
		
		
		//취소 버튼
		$('#cancel').on("click", function(e) {
			e.preventDefault();
			history.go(-1);
		});
		
		//이메일 관련
		oner_email_second_input.hide();
		oner_email_second.change(function() {
			if(oner_email_second.val() == "direct") {
				oner_email_second_input.show();
			}else{
				oner_email_second_input.hide();
			}
		});
		//이메일 select box
		var ary_email =['naver.com','nate.com','hanmail.net','gmail.com','lycos.co.kr','empal.com','paran.com','daum.net','kakao.com'];
		for (var i = 0; i < ary_email.length; i++) {
			oner_email_second.append("<option value="+ary_email[i]+">"+ary_email[i]+"</option>");
		}
		
		//휴대전화 번호 정규식
		var regPhone = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
		//이메일 정규식
		var regEmailFirst = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*$/;
		var regEmailSecond = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
		//ID,PW 정규식
		var regForIdPwd = /^[a-zA-Z0-9]{4,12}$/;
		
		//아이디체크
		$('#idCheck').on("click", function(e) {
			e.preventDefault();
			var data={oner_id : $('input[name=oner_id]').val()};
			idOrEmailCheck(data, function(result) {
				console.log(result);
				if(result == 'success'){
					id_check_flag = true;
					alert("사용 가능한 아이디 입니다.");
				}else{
					id_check_flag = false;
					alert("사용 불가능한 아이디 입니다..");
					$('input[name=oner_id]').focus();
					$('input[name=oner_id]').val('');
				}
			});
		});
		oner_id.change(function() {
			console.log("ID 변경됨");
			id_check_flag = false;
		});
		
		
		$("#join").on("click" , function(e) {
			e.preventDefault();
			
			if(!checkData(regForIdPwd,oner_id,"아이디")){
		    	return false;
			}
			if(id_check_flag == false){
				alert("아이디 중복 확인을 하세요.");
				return false;
			}
			if(!checkData(regForIdPwd,oner_pwd,"비밀번호")){
		    	return false;
			}
		    if (!checkData(regPhone,oner_phone,"휴대전화 번호")) {
		    	return false;
		    }
		    if (!checkData(regEmailFirst,oner_email_first,"이메일")) {
		    	return false;
		    }
		    if(oner_email_second.val() == "direct" && !checkData(regEmailSecond,oner_email_second_input,"이메일 직접입력")){
		    	return false;
		    }
		    if(oner_email_second.val() == "direct"){
			    oner_email.val(oner_email_first.val() + '@' + oner_email_second_input.val());
		    }else{
			    oner_email.val(oner_email_first.val() + '@' + oner_email_second.val());
		    }
		    
		    var data={oner_email : $('input[name=oner_email]').val()};
			idOrEmailCheck(data, function(result) {
				console.log(result);
				if(result == 'success'){
					$("#joinForm").attr("action", "/branch/join/register");
					$("#joinForm").attr("method", "post");
					$("#joinForm").submit();
				}else{
					alert("중복된 이메일 입니다.\n이메일을 확인해 주세요.");
					$('input[name=oner_email]').val('');
					return false;
				}
			});
		});
		
		function idOrEmailCheck(checkData, callback, error) {
			$.ajax({
				type : "post",
				url : "/branch/join/idOrEmailCheck",
				data : JSON.stringify(checkData),
				contentType : "application/json; charset=utf-8",
				success : function(result, status, xhr) {
					if(callback){
						callback(result)
					}
				}
			});
		}
		
		
		//입력한 정보 정규식 체크.
		function checkData(reg,data,message) {
			if(reg.test(data.val())){
				return true;
			}else{
				alert(message+" 을(를) 양식에 맞춰 작성해주세요.");
				data.val('');
				data.focus();				
			}
		}
		
		//전화번호 관련
		var phoneNum = document.getElementById("phoneNum");
		phoneNum.onkeyup = function(){
		  this.value = autoHypenPhone( this.value ) ;  
		}
		var autoHypenPhone = function(str){
		      str = str.replace(/[^0-9]/g, '');
		      var tmp = '';
		      if( str.length < 4){
		          return str;
		      }else if(str.length < 7){
		          tmp += str.substr(0, 3);
		          tmp += '-';
		          tmp += str.substr(3);
		          return tmp;
		      }else if(str.length < 11){
		          tmp += str.substr(0, 3);
		          tmp += '-';
		          tmp += str.substr(3, 3);
		          tmp += '-';
		          tmp += str.substr(6);
		          return tmp;
		      }else{              
		          tmp += str.substr(0, 3);
		          tmp += '-';
		          tmp += str.substr(3, 4);
		          tmp += '-';
		          tmp += str.substr(7);
		          return tmp;
		      }
		      return str;
		}
	});
	</script>
</body>
</html>