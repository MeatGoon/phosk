<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
<p> 카테고리 db읽고</p><br>
<p> 카테고리 분류하고</p><br>
<p> 그 안에서 이름,가격,옵션 등으로 나누고끝</p><br>
<table style = 'float:left;'>
<tr>
	<th>인기메뉴</th>
	<td>이름</td>
	<td>옵션1가격</td>
	<td>옵션2가격</td>	 
</tr>
<tr>
	<th>인기메뉴</th>
	<td>이름</td>
	<td>옵션1가격</td>
	<td>옵션2가격</td>	 
</tr>
<tr>
	<th>인기메뉴</th>
	<td>이름</td>
	<td>옵션1가격</td>
	<td>옵션2가격</td>	 
</tr>

</table>
</form>

</div>

</body>
</html>