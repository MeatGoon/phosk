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
<body>
	<p>지점관리자 로그인</p>
	<a href="/branch/login/index">메뉴관리</a><br/>
	<p>지점 선택페이지</p>
	<a href="/branch/login/choiceBranch">지점선택</a><br/>
	<p>qr 테이블관리</p>
	<a href="/branch/qr/index?branch_num=${branch_num}">qr관리</a><br/>
</body>
</html>