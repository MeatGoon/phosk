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
	<header>
		<nav>
			<ul class = "headul">
				<a class = "logo" href="http://localhost:8001/test/testList">로고</a>
				<li><button class = "middle">지점정보</button></li>
				<li><button class = "middle">QR및테이블</button></li>
				<li><button class = "middle">메뉴관리</button></li>
				<li><button class = "middle">예약관리</button></li>
				<li><button class = "middle">문의</button></li>
			</ul>
		</nav>
		<nav>
			<ul class = "headul">
				<li><a href="#" class = "last">로그인</a></li>
				<li><a href="#" class = "last">호출</a></li>
			</ul>
		</nav>
	</header>
	
	
	
	<jsp:include page="./test/menuedit.jsp"/>             
	
	
	<footer>

	</footer>
	
	

</body>



</html>