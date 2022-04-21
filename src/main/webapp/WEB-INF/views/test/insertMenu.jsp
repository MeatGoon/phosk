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
	<h1>등록페이지</h1>
	<div>
		<form id="insertForm" method="post">
			<div class="menu_box">
				<input type="hidden" name="branch_num" value="${cateTest.branch_num}"/>
				<select name="category_num">
					<c:forEach var="cateList" items="${cateList}">
						<c:choose>
							<c:when test="${cateList.category_num eq cateNum}">
								<option selected="selected" value="${cateList.category_num}">${cateList.category_name}</option>
							</c:when>
							<c:otherwise>
								<option value="${cateList.category_num}">${cateList.category_name}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div class="menu_box">
				<label for="item_name">음식명 : </label>
				<input class="menue_info" type="text" name="item_name"/>
			</div>
			<div class="menu_box">
				<label for="item_info">상세설명</label>
				<textarea class="menue_info" rows="" cols="" name="item_info" ></textarea>
			</div>
			<div class="menu_box BOption">
				<input type="text" name="basic_option" readonly="readonly" value="가격"/> :
				<input type="text" name="basic_price"/>
			</div>
			<div class="menu_box AOption">
			
			</div>
			<!-- 추가 버튼 클릭시 readonly 해제후 임의의 값을 먼저 넣은후 -->
			<!-- 만약 한번더 추가할시 현재 입력되어있는 옵션명을 비교? try catch? -->
		</form>
		<button type="button" id="insert_btn">등록</button>
		<button type="button" id="list_btn">목록이동</button>
	</div>
	<script>
		$("#list_btn").on('click', function() {
			location.href = "/test/menueManage?branch_num=${branchInfo}&category_num=${cateNum}";
		});
		$("#insert_btn").on('click', function() {
 			var text = $("select[name='category_num']").val();
			var result = 0 || null || "";
			if (text == result) {
				alert("카테고리를 선택해주시기 바랍니다.");
				console.log('if 여긴가');
			} else {
				console.log('else 여긴가');
				$("#insertForm").attr('action', '/test/insertMenu');
				$("#insertForm").submit();
				/* 자고 일어나서 왜 작동안하는지 원인 찾기 */
				
				/* 
				Uncaught TypeError: $(...) is not a function
   				 at HTMLButtonElement.<anonymous> (insertMenue?nowCate=3:111:21)
 				 at HTMLButtonElement.dispatch (jquery.min.js:2:43064)
  				 at HTMLButtonElement.v.handle (jquery.min.js:2:41048)
				*/
			}
		});
	</script>
</body>
</html>