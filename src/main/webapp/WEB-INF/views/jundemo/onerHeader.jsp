<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--@ page import="com.teamproject.groupone.logincheck.LoginCheck" --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title>포스크 - 온라인 메뉴주문</title>
<link rel="stylesheet" href="${path}/resources/css/onerHeader.css">
</head>



<body>
	<nav>
		<ul class = "headul">
			<a class = "logo" href="/">로고</a>
			<li><button type="button" class = "middle" onclick= "location.href='/branch/login/choiceBranch'">지점정보</button></li>
			<li><button type="button" class = "middle" onclick= "location.href='/branch/qr/index?branch_num=${branch_num}'">QR및테이블</button></li>
			<li><button type="button" class = "middle" onclick= "location.href='/test/cateList?branch_num=123-45-67890'">메뉴관리</button></li>
			<li><button type="button" class = "middle">예약관리</button></li>
			<li><button type="button" class = "middle">문의</button></li>
		</ul>
	</nav>
	<nav>
		<ul class = "headul">
			<li><a href="/branch/login/index" class = "last">로그인</a></li>
			<!-- <li><a href="/" class = "last">호출</a></li> -->
		</ul>
	</nav>
</body>



</html>