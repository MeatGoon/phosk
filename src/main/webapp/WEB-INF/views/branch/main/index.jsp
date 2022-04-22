<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<header>
		<jsp:include page="../../onerHeader.jsp"/>
</header>
<body>
	<h1>감사합니다 PHOSK 입니다</h1>
	<c:choose>
	<c:when test = "${loginInfo != null}">
	<p>좋은 하루 되세요</p>
	</c:when>
	<c:when test = "${loginInfo == null}">
	<p>로그인을 통해여 지점을 관리해주세요</p>
	</c:when>
	</c:choose>
</body>
</html>