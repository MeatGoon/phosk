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
<style>
.menu_box, #menueContainer {
	border: 1px solid black;
}

.menu_box {
	margin: 10px 5px 5px 5px;
	padding: 10px;
}
</style>
<body>
	<div class="menue_infobox">
		<button id="modify_btn">수정</button>
		<button id="accpt_btn" hidden="hidden">확인</button>
		<button id="delete_btn" hidden="hidden">삭제</button>
	</div>
	<div>
		<button type="button" id="list_btn">목록이동</button>
	</div>
	<div id="menueContainer">
		<form id="updateForm" method="post">
			<div class="menu_box">
				<input type="hidden" name="branch_num" value="${cateTest.branch_num}"/>
				<label>카테고리명 : </label>
				<input class="menue_info" type="hidden" name="category_num" value="${cateTest.category_num}"/><!-- 아이템 카테고리 이동시 사용할 부분 -->
				<input class="menue_info" type="hidden" name="change_category_num" value="${cateTest.category_num}"/>
				
				<!-- 시간 있을경우 select 박스로 수정 -->
				<label for="category_name">카테고리명</label>
				<input class="menue_info" type="text" name="category_name" value="${cateTest.category_name}"/>
			</div>
			<div class="menu_box">
				<!-- name명 수정 필요 -->
				<label>음식명 : </label>
				<input class="menue_info" type="hidden" name="item_num" value="${cateTest.item_num}"/>
				<input class="menue_info" type="text" name="item_name" value="${cateTest.item_name}"/>
			</div>
			<!--  -->
			<div class="menu_box">
				<label>상세 설명 : </label>
				<input class="menue_info" type="text" name="item_info" value="${cateTest.item_info}"/>
			</div>
			<c:forEach items="${bOptions}" var="bOptions">
			<div class="menu_box">
				<input type="hidden" name="basic_option" value="${bOptions.basic_option}"/>
				<label for="change_basic_option">기본옵션1</label>	<input class="menue_info" type="text" name="change_basic_option" value="${bOptions.basic_option}"/>
				<label for="basic_price">기본가격1</label>	<input class="menue_info" type="text" name="basic_price" value="${bOptions.basic_price}"/>
			</div>
			</c:forEach>
			<c:forEach items="${aOptions}" var="aOptions">
			<div class="menu_box">
				<input type="hidden" name="add_option" value="${aOptions.add_option}"/>
				<label for="change_add_option">추가옵션</label>	<input class="menue_info" type="text" name="change_add_option" value="${aOptions.add_option}"/>
				<label for="add_price">추가가격</label>	<input class="menue_info" type="text" name="add_price" value="${aOptions.add_price}"/>
			</div>
			</c:forEach>
			<div class="menu_box">
				<label for="item_lastDate">마지막수정일</label>	<input class="menue_info" type="text" name="item_lastDate" value="${cateTest.item_lastDate}"/>
				<label for="item_regiDate">등록일</label>		<input class="menue_info" type="text" name="item_regiDate" value="${cateTest.item_regiDate}"/>
			</div>
		</form>
	</div>
	
	<script>
		let form = $("#updateForm");
		let moveForm = $("#moveForm");

		$("#modify_btn").on("click", function() {
			$(".menue_info").attr("readonly", false);
			$("#modify_btn").attr("hidden", "hidden");
			$("#accpt_btn").attr("hidden", false);
			$("#delete_btn").attr("hidden", false);
		});

		$("#accpt_btn").on("click", function() {
			form.attr("action", "/test/itemUpdate");
			form.submit();
			/* $(".menue_info").attr("readonly", "readonly"); */
		});

		$("#delete_btn").on("click", function() {
			form.attr("action", "/test/deleteItem");
			form.submit();
		});
		function moveList() {
			location.href = "/test/cateList?branch_num=${cateTest.branch_num}&category_num=${cateTest.category_num}";
		}
		$("#list_btn").on("click", function() {
			if ($("#accpt_btn").is(":hidden")) {
				moveList();
				} else if (confirm("이전에 입력한 데이터는 저장되지 않습니다.\n목록으로 이동 하시겠습니까???") == true) { //확인
					moveList();
				} else { //취소
					return;
				}
			});
	</script>

</body>
</html>