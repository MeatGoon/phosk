<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
<head>

		<title>회원조회</title>
</head>
<header>
			<jsp:include page="../userheader.jsp"/>
</header>
<body>
	<div>
	<h1  style= ' text-align: center; margin-top : 10%;'>회원정보조회</h1>
	<form action="/userForm/user/userlist" method="get" name ="formname">
			<table style ='width:250px; border: 1px; solid pink'>
							<tr><th>닉네임</th><th>아이디</th><th>비밀번호</th></tr>						
							<c:forEach items="${register}" var = "list">
								<tr style= 'color : blue;'>	
									<td><c:out value="${list.member_nic}" /></td>						
									<td><c:out value="${list.member_id}" /></td>								
									<td><c:out value="${list.member_pwd}" /></td>													
								</tr>
							</c:forEach>
												
			</table>
	</form>	
	<script>function goBack() {window.history.back();}</script>
	<input class="back" type="button" value="뒤로가기" onClick= "goBack();">	
	</div>		
</body>
</html>