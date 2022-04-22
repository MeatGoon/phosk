<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--@ page import="com.teamproject.groupone.logincheck.LoginCheck" --%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title>포스크 - 온라인 메뉴주문</title>
<link rel="stylesheet" href="${path}/resources/css/onerHeader.css">
</head>



<body>

<c:choose>
	<c:when test = "${loginInfo == null}">
		<nav>
			<ul class = "headul">
				<a class = "logo" href="/branch/main/index" style="">로고</a>
			</ul>
		</nav>
		<nav>
			<ul class = "headul">
				<li><a href="/branch/login/index" class = "last">로그인</a></li>
			</ul>
		</nav>
	</c:when>
	<c:when test = "${loginInfo != null}">
		<nav>
			<ul class = "headul">
				<a class = "logo" href="/branch/main/index">로고</a>
				<li><button type="button" class = "middle" onclick= "location.href='/branch/login/choiceBranch'">지점정보</button></li>
				<li><button type="button" class = "middle" onclick= "location.href='/branch/qr/index?branch_num=${branchNumSession}'">QR및테이블</button></li>
				<li><button type="button" class = "middle" onclick= "location.href='/test/cateList?branch_num=${branchNumSession}'">메뉴관리</button></li>
			</ul>
		</nav>
		<nav>
			<ul class = "headul">
				<li><a href="/branch/main/logout" role="button" class= "last">로그아웃</a></li>
			</ul>
		</nav>
	</c:when>	
</c:choose>	
</body>
</html>