<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<title>회원 정보수정</title>
</head>
<style>
	.update_userlist{
		text-align: center;
	}
	.user_card{
		text-align: center;
	}
</style>
<header>
			<jsp:include page="../userheader.jsp"/>
</header>
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
			<form action="/userForm/user/updateuser" method="post" class= "update_userlist">						
				<div class="form-group">
					<label class="control" for="member_id" ></label>
					<input class="form" type="hidden" id="member_id" name="member_id" value="${login.member_id}"  readonly="readonly"/>
				</div>		
				<div class="form-groupk">
					<p>비밀번호변경</p><br>
					<label class="control" for="member_pwd"></label>
					<input class="forml" type="password" id="member_pwd" name="member_pwd" />
				</div>		
				<div class="form-group">
					<button class="btn" type="submit" id="submit">회원정보수정</button>
					<button class="cencle" type="button">취소</button>
				</div>
				</form>
				<div class= "user_card">
					<c:if test="${login != null }" >
						<table style ='border : 1px solid red;'>
									<tr><th>id</th><th>은행사</th><th>카드주</th></tr>		
							<c:forEach items="${mycard}" var = "list">
								<c:if test="${list.member_id eq login.member_id}" >													
									<tr>	
									<td><c:out value="${list.member_id} " /></td>						
									<td><c:out value="${list.cardinfo_bank}" /></td>								
									<td><c:out value="${list.cardinfo_holderName}" /></td>													
									</tr>
								</c:if>	
							</c:forEach>
						</table>
					</c:if>
						<input type="button" value="카드등록" onClick = "location.href='/userForm/cardinfo/cardinfoForm'"><br>															
				</div>
		</div>
		
	</body>
	
</html>