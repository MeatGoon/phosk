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
	<form action="/test/testUpdate" method="post">
			<label for="branch_num">사업자번호</label>		<input type="text" name="branch_num" value="${cateTest.branch_num}"/><br />
			<input type="hidden" name="category_num" value="${cateTest.category_num}"/>
			<label for="category_num">카테고리</label>		
			<label for="category_name">카테고리명</label>	<input type="text" name="category_name" value="${cateTest.category_name}"/><br />
			<label for="item_num">메뉴고유번호</label>		<input type="text" name="item_num" value="${cateTest.item_num}"/><br />
			<label for="item_name">메뉴명</label>			<input type="text" name="item_name" value="${cateTest.item_name}"/><br />
			<label for="item_image">메뉴이미지</label>		<input type="text" name="item_image" value="${cateTest.item_image}"/><br />
			<label for="item_info">메뉴정보</label>		<input type="text" name="item_info" value="${cateTest.item_info}"/><br />
			<label for="item_lastDate">마지막수정일</label>	<input type="text" name="item_lastDate" value="${cateTest.item_lastDate}"/><br />
			<label for="item_regiDate">등록일</label>		<input type="text" name="item_regiDate" value="${cateTest.item_regiDate}"/><br />
			<!-- 추가옵션 부분은 기능 구현이 힘들어 뺴야할수도 있을거 같음 -->
			<!-- 추가 옵션을 넣게 되면 기본옵션과 같이 복사되어 같은 내용일 2번나왔음 -->
			<!-- 테스트용은 db로 설명 가능 -->
			<c:forEach items="${bOptions}" var="bOptions">
				<input type="hidden" name="basic_option" value="${bOptions.basic_option}"/>
				<label for="change_basic_option">기본옵션1</label>	<input type="text" name="change_basic_option" value="${bOptions.basic_option}"/><br />
				<label for="basic_price">기본가격1</label>	<input type="text" name="basic_price" value="${bOptions.basic_price}"/><br />
			</c:forEach>
			<c:forEach items="${aOptions}" var="aOptions">
				<input type="hidden" name="add_option" value="${aOptions.add_option}"/>
				<label for="change_add_option">추가옵션</label>	<input type="text" name="change_add_option" value="${aOptions.add_option}"/><br />
				<label for="add_price">추가가격</label>	<input type="text" name="add_price" value="${aOptions.add_price}"/><br />
			</c:forEach>
		<button type="submit">테스트 버튼</button>
		<button>ㅇ</button>
	</form>
</body>
</html>