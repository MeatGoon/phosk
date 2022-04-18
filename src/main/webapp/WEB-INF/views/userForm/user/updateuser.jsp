<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
	<jsp:include page="../userheader.jsp"/>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
			});
		
		})
	</script>
	<body>
		<div id="container">
			<form action="/userForm/user/updateuser" method="post">						
				<div class="form-group">
					<label class="control" for="member_id" >아이디</label>
					<input class="form" type="text" id="member_id" name="member_id" value="${login.member_id}" style=' color:red;' readonly="readonly"/>
				</div>		
				<div class="form-groupk">
				기존페스워드
				</div>
				<div class="form-groupk">
					<label class="control" for="member_pwd">패스워드</label>
					<input class="forml" type="password" id="member_pwd" name="member_pwd" />
				</div>		
				<div class="form-group">
					<button class="btn" type="submit" id="submit">회원정보수정</button>
					<button class="cencle" type="button">취소</button>
				</div>
				</form>
				<div>
							<p>카드정보</p>
					<table style ='border : 1px solid red;'>
						<tr><th>번호</th><th>은행사</th><th>카드주</th></tr>						
						<c:forEach items="${mycard}" var = "list">
							<tr>	
							<td><c:out value="1" /></td>						
							<td><c:out value="${list.cardinfo_bank}" /></td>								
							<td><c:out value="${list.cardinfo_holderName}" /></td>													
							</tr>
						</c:forEach>	
					</table>
						<input type="button" class="cc" value="카드등록" onClick = "location.href='/userForm/cardinfo/cardinfoForm'"><br>															
				</div>
		</div>
		
	</body>
	
</html>