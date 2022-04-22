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
	<a href="/test/cateList?branch_num=${branchNumSession}">메뉴 관리</a>&nbsp;&nbsp;
	<a href="/branch/login/choiceBranch">지점선택</a>&nbsp;&nbsp;
	<a href="/branch/qr/index?branch_num=${branchNumSession}">qr관리</a>&nbsp;&nbsp;
	<a href="/branch/login/index">로그아웃</a><br/>
</body>
</html>