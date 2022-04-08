<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<head>
	<jsp:include page="../userheader.jsp"/>
	<title>회원가입창</title>
</head>

<body>	
<script type="text/javascript">
		
	$(function(){		
	$(".regist_btn").on("click", function(){
					if($("#member_nic").val()==""){
						alert("닉네임을 입력해주세요.");
						$("#member_nic").focus();
						return false;
					}
					if($("#member_id").val()==""){
						alert("아이디를 입력해주세요.");
						$("#member_id").focus();
						return false;
					}
					if($("#member_pwd").val()==""){
						alert("비밀번호를 입력해주세요.");
						$("#member_pwd").focus();
						return false;
					}
					if($("#member_pwd2").val()==""){
						alert("비밀번호확인을 입력해주세요.");
						$("#member_pwd").focus();
						return false;
					}
		});
	
	});
	</script>

    <div class = "register_main">
		<form action="/userForm/user/register" method="POST">				
			<div class= "test">
				<input type="text" name="member_nic" id ="member_nic" maxlength="10" placeholder="닉네임" />											
			</div>	
				<input type="button"  class='as' id="check_button" value="check" onclick="checkid();">	
		
			<br>			
			<div class= "test">
				<input  type="text" name="member_id" id ="member_id" maxlength="11" placeholder="아이디 입력 (5~11자)" />							
			</div>
				<input type="button"  class='as' id="check_button" value="check" onclick="checkid();">
			<br>
			<div class= "test">
				<input  class="form-control" type="password"  name="member_pwd" id ="member_pwd" maxlength="20"
					placeholder="비밀번호" />
			</div>
			<div class= "test">
				<input   class="form-control" type="password" id ="member_pwd2" maxlength="20" placeholder="비밀번호확인" />
				<span id="alert-success" style="display: none;">비밀번호가 일치합니다.</span>
    			<span id="alert-danger" style="display: none; color: #d92742; font-weight: bold; ">비밀번호가 일치하지 않습니다.</span>
			</div>
			<script>
				    $('.form-control').focusout(function () {
				        var pwd1 = $("#member_pwd").val();
				        var pwd2 = $("#member_pwd2").val();
				  
				        if ( pwd1 != '' && pwd2 == '' ) {
				            null;
				        } else if (pwd1 != "" || pwd2 != "") {
				            if (pwd1 == pwd2) {
				                $("#alert-success").css('display', 'inline-block');
				                $("#alert-danger").css('display', 'none');
				            } else {
				                alert("비밀번호가 일치하지 않습니다. 비밀번호를 재확인해주세요.");
				                $("#alert-success").css('display', 'none');
				                $("#alert-danger").css('display', 'inline-block');
								$('#member_pwd2').val('');
				                //비밀번호 칸이 공백일때 무한재생문제
				            }
				        }
				    });
			</script>
			<br>
			<div>
				<input type="button" class="cc" value="카드등록" onClick = "location.href='/userForm/cardinfo/cardinfoForm'"><br>
				<table  style ='width:250px; border : 1px solid red;'>
							<tr><th>번호</th><th>은행사</th><th>카드주</th></tr>						
							<c:forEach items="${cardinfoForm}" var = "list">
								<tr>	
									<td><c:out value="1" /></td>						
									<td><c:out value="${list.cardinfo_bank}" /></td>								
									<td><c:out value="${list.cardinfo_holderName}" /></td>													
								</tr>
							</c:forEach>					
				</table>
			</div>		
			<div>
				<div class="register_but">
					<input class= "regist_btn" type="submit" value="회원가입" />
					<input type="button" value="취소" onClick = "location.href='/userForm/usertest'" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>