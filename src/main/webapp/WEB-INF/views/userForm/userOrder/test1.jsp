<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv = "Content-Type" content= "text/html; charset=UTF-8">
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
			<p>qr로 읽은 branch정보에서 사진 불러오기 임시용 이미지 불러옴</p>
			<div>
			<img alt="바위" src="/resources/images/rock.jpg" width = "250px;" height = "150px;">
			</div>
			</form>	
		</div>
	</div>
	
	
	
<!-- ----------------------------------------------------------------------------------------- -->
	
	<div class="right">
		<div>
			<c:choose>
				<c:when test = "값이 없을떄">
					내용이 없습니다.
				</c:when>
				<c:otherwise>
					<form action="" method= "get">	
						<div>
							<div>
							<h1>미니장바구니</h1>
								<table>
								<tr>
								<th>이름</th><th>수량</th><th>가격</th>
								</tr>
								<c:foreach 장바구니에 정보추가의 경우>
								
								
								</c:foreach>
								</table>
							</div>
							<div>
								<input type="button" value="자세히보기"/>
								<input type="button" value="가격중간점검"/>
							</div>
						</div>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
</body>
<footer>
	<jsp:include page="../dumi1.jsp"/>
</footer>
</html>