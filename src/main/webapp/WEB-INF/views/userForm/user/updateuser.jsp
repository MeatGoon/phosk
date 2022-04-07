<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
	<jsp:include page="../userheader.jsp"/>	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	 	
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>회원 정보수정</title>
</head>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cencle").on("click", function(){
				
				location.href = "/userForm/usertest";						    
			})		
			$("#submit").on("click", function(){
				if($("#member_pwd").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#member_pwd").focus();
					return false;
				}
				if($("#member_nic").val()==""){
					alert("성명을 입력해주세요.");
					$("#member_nic").focus();
					return false;
				}
			});
		
		})
	</script>
	<body>
		<section id="container">
			<form action="/userForm/user/updateuser" method="post">
						
			
				<div class="form-groupk">
				기존페스워드
				</div>
				<div class="form-groupk">
					<label class="control" for="member_pwd">패스워드</label>
					<input class="forml" type="password" id="member_pwd" name="member_pwd" />
				</div>
				<div class="form-groupk">
				기존닉네임
				</div>
				<div class="form-group">
					<label class="control" for="member_nic">닉네임</label>
					<input class="form" type="text" id="member_nic" name="member_nic" value="${login.member_nic} "/>
				</div>
					<div class="form-group">
					<label class="control" for="member_id" >아이디</label>
					<input class="form" type="text" id="member_id" name="member_id" value="${login.member_id}" readonly="readonly"/>
				</div>

				<div class="form-group">
					<button class="btn" type="submit" id="submit">회원정보수정</button>
					<button class="cencle" type="button">취소</button>
				</div>
			</form>
		
		</section>
		
	</body>
	
</html>