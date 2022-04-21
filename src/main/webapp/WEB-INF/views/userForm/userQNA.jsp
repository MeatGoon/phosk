<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
	<title>QNA</title>
</head>
<header>
			<jsp:include page="./userheader.jsp"/>
</header>
<body>
<h1>문의 페이지입니다</h1>
<p> 문의하세요</p>
${cardinfoForm}
<h1><a href = "/userForm/usertest">테스트페이지</a></h1>
</body>
</html>