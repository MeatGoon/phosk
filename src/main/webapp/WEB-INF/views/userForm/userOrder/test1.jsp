<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	.testContents{
		border: 1px solid black;
		 display: flex;
		 justify-content: center;
	}
	.testFooter{
		border: 1px solid blue;
	}
	.left, .right{
		border: 5px solid green;
		 margin:0px;
		 width: 360px;
		 height: 250px;
		
	}

	 
</style>
<header>
			<jsp:include page="../userheader.jsp"/>
</header>
<body>
<div class="testContents">
<div class="left">
<h1>가게사진</h1>
<p>qr로 읽은 branch정보에서 사진 불러오기</p>
</div>
<div class="right">
<h1>미니장바구니</h1>
<p> qr테이블 생성(더미 branch생성으로 위치잡은상태)<br>
	푸터에 더미용 음식정보파일 1개 생성<br>
	이후 더미 1파일을 이용해서 장바구니 구현
	
</p>
</div>

</div>
</body>
<footer>
	<jsp:include page="../dumi1.jsp"/>
</footer>
</html>