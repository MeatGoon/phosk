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
	<p>메인페이지</p>
	<a>지점정보</a><br/>
	<a>테이블 관리</a><br/>
	<a href="/test/cateList?branch_num=123-45-67890">메뉴관리</a><br/>
	<a href="/branch/qr/index?branch_num=${branch_num}">qr관리</a><br/>
</body>
</html>