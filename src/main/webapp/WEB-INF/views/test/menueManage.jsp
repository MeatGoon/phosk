<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head></head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	/* overflow: hidden 해야 카테고리 변경시 둠칫둠칫두둠칫 안움직임 */
	overflow: scroll;
	display: block;
}

div {
	margin: 0 auto;
	display: block;
}

.categoryCon, .menueContainer, .menueInfo_container, #category_names {
	border: 1px solid black;
}

button {
	cursor: pointer;
}

.mainContainer {
	width: 1080px;
	height: 800px;
}

.categoryCon {
	width: 320px;
	height: 800px;
	float: left;
	height: 100%;
}

#category_names {
	width: 300px;
	height: 50px;
	margin: 0 auto;
	display: flex;
	justify-content: center;
}

.categoryCon, .menueContainer {
	overflow: auto;
}

.menueContainer {
	width: 700px;
	float: right;
	height: 100%;
}

#itemModify, #checked_menue {
	width: 50px;
	height: 50px;
	margin: 5px auto;
}

#itemModify {
	float: right;
}

#checked_menue {
	float: left;
}

#delCategory_btn, #list_btn {
	float: right;
}

#insert_btn {
	width: 100%;
	margin: 0 auto;
}

.menue_text {
	margin: 0 20px 0 10px;
}

.menue_text_top {
	
}

.menueInfo_container {
	height: 70px;
}

.menueInfo {
	margin: 5px 0 10px;
}

.menueInfo_top, .menueInfo_bottom {
	width: 550px;
	float: left;
}
</style>
<header>
		<jsp:include page="../onerHeader.jsp"/>
</header>
<body>
	<div class="mainContainer">
		<div class="categoryCon">
			<div>
				<button id="add_cate_btn" value="${cateNum}">카테고리 추가</button>
			</div>
			<div class="categort_btns">
				<c:forEach items="${cateList}" var="cateList">
					<button value="${cateList.category_num}" id="category_names" style="color: blue;">${cateList.category_name}</button>
				</c:forEach>
			</div>
		</div>
		<div class="menueContainer">
			<div class="btnTest" style="position: sticky; top: 0; background-color: white; border-bottom: 1px solid black;">
				<form action="/test/updateCateName" method="post" id="modifyForm">
					<c:forEach var="cateList" items="${cateList}">
						<c:if test="${cateList.category_num eq cateNum}">
							<input type="hidden" name="category_num" value="${cateList.category_num}"/>
							<input type="text" name="category_name" value='${cateList.category_name}' />
							<button type="button" value="${cateList.category_num}" id="modify_cateName">수정</button>
						</c:if>
					</c:forEach>
					<button type="button" value="${cateNum}" id="list_btn">목록이동</button>
					<c:if test="${cateNum ne 0}">
						<button type="button" value="${cateNum}"
							id="delCategory_btn">카테고리 삭제</button>
					</c:if>
				</form>
			</div>
			<div class="menue_eachform">
				<c:forEach items='${cateTest}' var='cateTest'>
					<div class='menueInfo_container'>
						<div>
							<button name="${cateTest.item_num}" value="${cateTest.category_num}" id="itemModify">수정</button>
						</div>
						<div>
							<input type="checkbox" name="item_num" id="checked_menue" value="${cateTest.item_num}" />
						</div>
						<div class="menueInfo menueInfo_top">
							<span class="menue_text menue_text_top menue_info_name">음식명 : ${cateTest.item_name}</span>
							<c:forEach items="${itemPrice}" var="itemPrice">
								<c:if test="${itemPrice.item_num eq cateTest.item_num}">
									<span class="menue_text menue_text_top menue_info_price">${itemPrice.basic_option} : <fmt:formatNumber value="${itemPrice.basic_price}"></fmt:formatNumber>&nbsp;원</span>
								</c:if>
							</c:forEach>
							
						</div>
						<div class="menueInfo menueInfo_bottom">
							<span class="menue_text menue_info_detail">${cateTest.item_info}</span>
						</div>
					</div>
				</c:forEach>
			</div>
			<div style="position: sticky; bottom: 0; background-color: white;">
				<c:if test="${cateNum ne 0}">
					<div>
						<button value="${cateNum}" id="insert_btn">메뉴등록</button>
					</div>
				</c:if>
				<c:choose>
					<c:when test="${cateNum ne 0}">
						<button id="cheked_btn" class="del_checked_btn">선택 삭제</button>
						<button id="cheked_btn" class="best_checked_btn">인기 등록</button>
					</c:when>
					<c:otherwise>
						<button id="cheked_btn" class="del_bestMenu_btn">인기메뉴 해제</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<form id="moveForm" method="get">
		<input type="hidden" name="branch_num" value="${branchInfo}"/>
		<input type="hidden" name="category_num" value="${cateNum}"/>
	</form>
	<script>
		let moveForm = $("#moveForm");
		$(document).on("click", "#category_names", function() {
			var cateVal = $(this).val();
			moveForm.attr("action", "/test/menueManage");
			$("input[name=category_num]").val(cateVal);
			moveForm.submit();
		});
		$('#insert_btn').on('click', function() {
			moveForm.attr('method', 'get');
			moveForm.attr('action', '/test/insertMenu');
			moveForm.submit();
			});
		$('#modify_cateName').on('click', function() {
			let form = $('#modifyForm');
			form.append('<input type="hidden" name="branch_num" value="${branchInfo}"/>');
			form.submit();
			});
		
		$('#delCategory_btn').on('click', function() {
			moveForm.attr('method', 'post');
			if (confirm('확인시 하위 메뉴와 같이 삭제됩니다') == true) {
				moveForm.attr('action', '/test/deleteCategory');
				moveForm.append('<input type="hidden" name="category_num" value="' + $(this).val() + '"/>');
				moveForm.submit();
				} else {
					return;
				}
			moveForm.attr('action', '/test/deleteCategory');
			moveForm.append('<input type="hidden" name="category_num" value="' + $(this).val() + '"/>');
			moveForm.submit();
			});
		
		$(document).ready(function() {
			$(document).on('click', 'button[id="itemModify"]', function(e) {
				var item_num = $(this).attr('name');
				console.log(item_num);
				moveForm.append("<input type='hidden' name='item_num' value='"+ item_num + "' />");
				moveForm.attr("action", "/test/itemModify");
				moveForm.submit();
				});
			});
		/* 수정페이지로 이동하기 */
		$(document).on("click", "#list_btn", function() {
			console.log('test');
			moveForm.attr('method', 'get');
			moveForm.append('<input type="hidden" name="cateTest" value="' + $(this).val() + '"/>');
			moveForm.attr('action', '/test/cateList');
			moveForm.submit();
			});
		
		/* 새 카테고리 추가 */
		$('#add_cate_btn').on('click', function() {
			moveForm.attr('method', 'post');
			moveForm.attr('action', '/test/insrtCategory');
			moveForm.append("<input type='hidden' name='category_name' value='새 카테고리'>");
			moveForm.submit();
			});

		/* 다중 삭제, 등록 ajax */
		$(document).ready(function() {
			$(document).on("click", "button[id='cheked_btn']", function() {
				var checkType = $(this).attr('class');
				var url;
				console.log(checkType);
				if (checkType == "del_checked_btn") {
					console.log("메뉴 선택 삭제");
					checkedBtnfun("/test/deleteChk");
				} else if (checkType == "best_checked_btn") {
					console.log("인기메뉴 등록");
					checkedBtnfun("/test/addBestMenu");
				} else if (checkType == "del_bestMenu_btn") {
					console.log("인기메뉴 삭제");
					checkedBtnfun("/test/deleteBestMenu");
				} else {
					alert('오류발생');
				}
			});
		});

		function checkedBtnfun(url) {
			var checkedbtn = new Array(); /* 체크된 value의 값을 저장할 배열 생성 */
			var branchNum = "${branchInfo}";
			var categoryNum = ${cateNum};
			console.log(url + 'url 성공적 전송완료');
			$("input:checkbox[name='item_num']:checked").each(function() {
				/* input 태그의 checkbox의 name='menue_name'가 체크 가된 만큼 .each로 반복 하여 이벤트 발생 */
				checkedbtn.push($(this).val()); /* 배열에 담을 checkbox의 value 값 */
				console.log(checkedbtn); /* 배열에 담기는지 테스트 */
			});
			$.ajax({
				url : url, // controller에서 설정해둔 postmapping의 url
				type : "POST", // controller 의 mapping 타입이 Get 인지 Post 인지 설정
				traditional : true, // 전통성 ex) true = checkedbtn='볶음밥', false = checkedbtn[]='볶음밥'
				data : {
					branchNum : branchNum,
					categoryNum : categoryNum,
					checkedbtn : checkedbtn
				/* 담아둔 배열을 controller로 보낸다 */
				},
				success : function(testdata) {
					if (url === "/test/deleteChk") {
						alert(checkedbtn.length + '개 메뉴 삭제.');
					}else if (url === "/test/addBestMenu") {
						alert(checkedbtn.length + '개 인기메뉴 등록.');
					}else if (url === "/test/deleteBestMenu") {
						alert(checkedbtn.length + '개 인기메뉴 해제.');
					}else {
						alert("실패");
					}
					console.log('성공!');
					location.reload();
				}
			});
		}
	</script>
</body>
</html>