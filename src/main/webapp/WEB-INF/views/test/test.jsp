<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/test/testUpdate" method="post">
		<c:forEach items="${cateTest}" var="cateTest">
			<label for="branch_num">사업자번호</label>		<input type="text" name="branch_num" value="${cateTest.branch_num}"/><br />
			<label for="category_num">카테고리</label>		<input type="text" name="category_num" value="${cateTest.category_num}"/><br />
			<label for="category_name">카테고리명</label>	<input type="text" name="category_name" value="${cateTest.category_name}"/><br />
			<label for="item_num">메뉴고유번호</label>		<input type="text" name="item_num" value="${cateTest.item_num}"/><br />
			<label for="item_name">메뉴명</label>			<input type="text" name="item_name" value="${cateTest.item_name}"/><br />
			<label for="item_image">메뉴이미지</label>		<input type="text" name="item_image" value="${cateTest.item_image}"/><br />
			<label for="item_info">메뉴정보</label>		<input type="text" name="item_info" value="${cateTest.item_info}"/><br />
			<label for="item_lastDate">마지막수정일</label>	<input type="text" name="item_lastDate" value="${cateTest.item_lastDate}"/><br />
			<label for="item_regiDate">등록일</label>		<input type="text" name="item_regiDate" value="${cateTest.item_regiDate}"/><br />
			<label for="basic_option1">기본옵션1</label>	<input type="text" name="basic_option1" value="${cateTest.basic_option1}"/><br />
			<label for="basic_option2">기본옵션2</label>	<input type="text" name="basic_option2" value="${cateTest.basic_option2}"/><br />
			<label for="basic_option3">기본옵션3</label>	<input type="text" name="basic_option3" value="${cateTest.basic_option3}"/><br />
			<label for="basic_option4">기본옵션4</label>	<input type="text" name="basic_option4" value="${cateTest.basic_option4}"/><br />
			<label for="basic_price1">기본가격1</label>	<input type="text" name="basic_price1" value="${cateTest.basic_price1}"/><br />
			<label for="basic_price2">기본가격2</label>	<input type="text" name="basic_price2" value="${cateTest.basic_price2}"/><br />
			<label for="basic_price3">기본가격3</label>	<input type="text" name="basic_price3" value="${cateTest.basic_price3}"/><br />
			<label for="basic_price4">기본가격4</label>	<input type="text" name="basic_price4" value="${cateTest.basic_price4}"/><br />
			<label for="add_option1">추가옵션1</label>		<input type="text" name="add_option1" value="${cateTest.add_option1}"/><br />
			<label for="add_option2">추가옵션2</label>		<input type="text" name="add_option2" value="${cateTest.add_option2}"/><br />
			<label for="add_option3">추가옵션3</label>		<input type="text" name="add_option3" value="${cateTest.add_option3}"/><br />
			<label for="add_option4">추가옵션4</label>		<input type="text" name="add_option4" value="${cateTest.add_option4}"/><br />
			<label for="add_option5">추가옵션5</label>		<input type="text" name="add_option5" value="${cateTest.add_option5}"/><br />
			<label for="add_price1">추가가격1</label>		<input type="text" name="add_price1" value="${cateTest.add_price1}"/><br />
			<label for="add_price2">추가가격2</label>		<input type="text" name="add_price2" value="${cateTest.add_price2}"/><br />
			<label for="add_price3">추가가격3</label>		<input type="text" name="add_price3" value="${cateTest.add_price3}"/><br />
			<label for="add_price4">추가가격4</label>		<input type="text" name="add_price4" value="${cateTest.add_price4}"/><br />
			<label for="add_price5">추가가격5</label>		<input type="text" name="add_price5" value="${cateTest.add_price5}"/><br />
		</c:forEach>
		테스트<input type="text" name="testArr" />
		테스트<input type="text" name="testArr" />
		테스트<input type="text" name="testArr" />
		테스트<input type="text" name="testArr" />
		테스트<input type="text" name="testArr" />
		<button type="submit">수정</button>
	</form>
</body>
</html>