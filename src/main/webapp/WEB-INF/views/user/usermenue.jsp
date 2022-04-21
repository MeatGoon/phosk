<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<head>
<meta charset="UTF-8">
<title>온라인 메뉴판</title>
</head>
<header>
			<jsp:include page="../userForm/userheader.jsp"/>
</header>
<body>
<h1>온라인 메뉴판입니다</h1>
<div>
<form action="">
<p> 추가옵션부분 삽입해서 가격만 기재하면 마무리</p>

<table style = 'float:left; '>

		<c:forEach items="${catemenulist}" var = "cmenu">
			<tr >
					
				<tr><c:out value="${cmenu.category_name}" /></tr>
				<c:forEach items="${itemmenulist}" var = "imenu">
				<tr>
				<c:if test="${cmenu.category_num eq imenu.category_num}" >	
				<td><c:out value="${imenu.item_image}" /></td>
				<td><c:out value="${imenu.item_name}" /></td>
				<td><c:out value="${imenu.item_info}" /></td>
				</c:if>
				</tr>				
				</c:forEach>							
			</tr>
		</c:forEach>
</table>

</form>

</div>

</body>
</html>