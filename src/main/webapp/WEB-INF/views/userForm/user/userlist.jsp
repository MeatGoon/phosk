<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
<head>
		<jsp:include page="../userheader.jsp"/>
</head>
<body>
	<div>
	<h1  style= ' text-align: center;'>회원정보조회</h1>
	<form action="/userForm/user/userlist" method="get">
			<table style ='width:250px; border: 1px; solid pink'>
							<tr><th>닉네임</th><th>아이디</th><th>비밀번호</th></tr>						
							<c:forEach items="${register}" var = "list">
								<tr>	
									<td><c:out value="${list.member_nic}" /></td>						
									<td><c:out value="${list.member_id}" /></td>								
									<td><c:out value="${list.member_pwd}" /></td>													
								</tr>
								<input type="button" value="정보수정" onClick = "location.href='/userForm/user/updateuser'"/>
							</c:forEach>
												
			</table>
	</form>		
	</div>		
</body>
</html>