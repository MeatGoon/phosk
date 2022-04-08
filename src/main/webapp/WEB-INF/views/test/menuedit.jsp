<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/onerHeader.css">
<script language="javascript">
	function showmenueditPopup() { window.open("./test/menueditpopup/menuEditPopup", "", "width=400, height=600, left=100, top=50"); }
</script>
</head>
<body class = "menueditbody">
	<section class = "left">
		<ul>
			<li>카테고리</li>
			<li><a>카테고리명1</a></li>
			<li><a>카테고리명2</a></li>
			<li><a>카테고리명3</a></li>
			<li><a>카테고리명4</a></li>
			<li><a>카테고리명5</a></li>
		</ul>
		<ul>
			<li><button> 개별 카테고리 관리  →</button></li>
		</ul>
	</section>
	<section class = "right">
		<ul>
			<li>카테고리명</li>
			<li><a>메뉴관리</a></li>
			<li>
				<input type="button" value="메뉴등록" onclick="showmenueditPopup()">
			</li>
		</ul>
	</section>
</body>
</html>