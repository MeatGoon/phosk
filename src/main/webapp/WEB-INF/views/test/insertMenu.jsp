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
				<input type="hidden" name="branch_num" value="${branchInfo}"/>
				<label for="category_num">카테고리 선택 : </label><select name="category_num">
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
			<h3>가격</h3>
			<div class="menu_box BOption">
				<input type="text" name="basic_option" readonly="readonly" value="가격"/> :
				<input type="text" name="basic_price"/>
				<button type="button" id="addBOption">추가</button>
			</div>
			<h3>추가 옵션</h3>
			<div class="menu_box AOption">
			
				<button type="button" id="addAOption">추가</button>
			</div>
			<!-- 추가 버튼 클릭시 readonly 해제후 임의의 값을 먼저 넣은후 -->
			<!-- 만약 한번더 추가할시 현재 입력되어있는 옵션명을 비교? try catch? -->
		</form>
		<button type="button" id="insert_btn">등록</button>
		<button type="button" id="list_btn">목록이동</button>
		${result}
	</div>
		<form id="moveForm" method="post">
		<input type="text" name="branch_num" value="${branchInfo}"/>
	</form>
	<script>
		$(document).ready(function() {
			$(document).on("click", "#addAOption", function() {
				var branchNum = "${branchInfo}";
				var aOpName = $("#add_option").val();
				var aOpPrice = $("#add_price").val();
				if (aOpPrice == null) {
					aOpPrice = 0;
				}
				$("#add_price").attr("readonly", "readonly");
				$("#add_option").attr("readonly", "readonly");
				$(".AOption").prepend("<button id='deleteOption'>삭제</button>&nbsp;<br />");
				$(".AOption").prepend("<input type='text' id='add_price' name='add_price'/>");
				$(".AOption").prepend("<input type='text' id='add_option' name='add_option' placeholder='한글 3자리까지' /> :&nbsp;");
				
				console.log(aOpName);
				console.log(aOpPrice);
				$.ajax({
					url : "/test/addOption",
					type : "post",
					data : {
						branchNum : branchNum,
						aOpName : aOpName,
						aOpPrice : aOpPrice,	
					},
					success : function(testdata) {
						console.log("전송성공");
							
					}
				});
			});
		});

		
		
		$("#list_btn").on('click', function() {
			$("#moveForm").attr("action", "/test/moveMenueManage");
			$("#moveForm").submit();
		});
		$("#insert_btn").on('click', function() {
			var aOpName = $("#add_option").val();
			var result = null || "";
			if (aOpName == result) {
				alert("추가옵션에 빈칸이 있습니다.");
				return;
			} else {
				console.log('else 여긴가');
				$("#insertForm").attr('action', '/test/insertMenu');
				$("#insertForm").submit();
			}
		});
	</script>
</body>
</html>