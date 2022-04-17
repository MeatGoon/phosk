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
	<h1>회원수정</h1>
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
				<div class= "user_card" >
					<c:if test="${login != null }" >
						<table style ='border : 1px solid red; '>
									<tr><th>은행사</th><th>카드번호</th><th>카드주</th></tr>		
							<c:forEach items="${mycard}" var = "list">
								<c:if test="${list.member_id eq login.member_id}" >													
									<tr>	
									<td><c:out value=" ${list.cardinfo_bank}" /></td>						
									<td><c:out value="${list.cardinfo_cardNum}" /></td>								
									<td><c:out value="${list.cardinfo_holderName}" /></td>
									<td><input  type="text" id="cardinfo_cardNum" name="cardinfo_cardNum" value="${list.cardinfo_cardNum}"  /></td>
									<td><button type="submit" id= "delete_btn" >카드삭제</button></td>												
									</tr>
									<script>
									var form = $("#updateForm")
									
									   $("#delete_btn").on("click", function(){
							        form.attr("action", "/writecard");
							        form.attr("method", "post");
							        form.submit();
							   	 });
									</script>	
								</c:if>	
							</c:forEach>
							
						</table>
					</c:if>
						<input type="button" value="카드등록" onClick = "location.href='/userForm/cardinfo/cardinfoForm'"><br>															
				</div>
		</div>
		
	</body>
	
</html>