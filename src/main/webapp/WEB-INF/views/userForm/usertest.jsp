<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>
<html>

<head>
	<title>home</title>

		<jsp:include page="./userheader.jsp"/>

</head>
<body>

	<h2><a href = "/userForm/cardinfo/cardinfoForm">카드등록</a></h2>
	<h2><a href = "/userForm/user/register">회원가입</a></h2>
	<h2><a href = "/userForm/user/loginpage">로그인</a></h2>

</body>
</html>
