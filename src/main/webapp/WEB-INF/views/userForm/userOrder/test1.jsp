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
		 display: flex;
		 justify-content: center;
		 margin-top: 100px;
		 margin-bottom: 50px;
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
		<div>
			<form action="" method="get">
			<h1>가게사진</h1>
			<p>qr로 읽은 branch정보에서 사진 불러오기</p>
			</form>	
		</div>
	</div>
	
	
	
<!-- ----------------------------------------------------------------------------------------- -->
	
	<div class="right">
		<div>
			<form action="" method= "get">
				<div>
					<div>
						<h1>미니장바구니</h1>
						<p> qr테이블 생성(더미 branch생성으로 위치잡은상태)<br>
						푸터에 더미용 음식정보파일 1개 생성<br>
						이후 더미 1파일을 이용해서 장바구니 구현
					</p>
					</div>
					<div>
					<input type="button" value="자세히보기"/>
					<input type="button" value="가격중간점검"/>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
<footer>
	<jsp:include page="../dumi1.jsp"/>
</footer>
</html>