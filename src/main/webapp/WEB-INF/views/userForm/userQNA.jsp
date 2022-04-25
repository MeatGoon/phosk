<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
	<title>QNA</title>
</head>
<style>
	.qna-top{
		margin-top : 20%;
		width : 40%;
	}
	.qna{
	border : 3px solid black ;
	text-align : center;
	
	}
	.tete{
	border : 3px solid black ;
	text-align : center;
	margin-bottom : -3px;
	}
</style>
<header>
			<jsp:include page="./userheader.jsp"/>
</header>
<body>
<div class= "qna-top">
<div class = "tete">
<h3>관리자기능으로 사용</h3>
</div>
<div class = "qna">
<p> 문의하세요 (미구현)</p>
<a href = "/userForm/user/userlist">회원정보조회확인</a>
</div>
</div>
</body>
</html>