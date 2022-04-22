<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QR table detail</title>
<style type="text/css">
div {
	float: left;
	margin: auto;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/qrcode.js"></script>
</head>
<jsp:include page="../main/index.jsp"/>
<body>
	<div>
		<div id="qrcode">
			<input type="hidden" id="url"
				value="http://localhost/branch/qr/index?${qrDetail.qrTable_url}">
		</div>
		<div style="margin: auto; margin-left: 15px;">
			<form id="operForm">
				<label for="branch_num">사업자 번호 : </label><input type="text"
					name="branch_num" value="${qrDetail.branch_num}"
					readonly="readonly"><br /> <label for="qrTable_url">현재
					URL : </label><input type="text" name="qrTable_url"
					value="${qrDetail.qrTable_url}" readonly="readonly"><br />
				<label for="qrTable_num">테이블 번호 : </label><input type="text"
					name="qrTable_num" value="${qrDetail.qrTable_num}"><br />
					<input type="hidden" name="qrTable_index" value="${qrDetail.qrTable_index}">

				<button type="submit" data-oper="modify">수정</button>
				<button type="submit" data-oper="remove">삭제</button>
				<button type="submit" data-oper="list">목록</button>
			</form>
		</div>
	</div>


	<script type="text/javascript">
		$(document).ready(function() {
			//qr코드 생성
			var qrcode = new QRCode(document.getElementById("qrcode"), {
				//가로, 세로 높이 조절
				width : 300,
				height : 300
			});

			//input:text에 들어있는 value를 qr코드로 바꿔주는 function
			function makeCode() {
				var elText = document.getElementById("url");

				//value가 비어있으면
				if (!elText.value) {
					return;
				} else {
					qrcode.makeCode(elText.value);
				}
			}
			makeCode();

			$("button[data-oper='modify']").on("click", function(e) {
				e.preventDefault();
				var qrInfo = {
					branch_num : $('input[name=branch_num]').val(),
					qrTable_num : $('input[name=qrTable_num]').val(),
					qrTable_url : $('input[name=qrTable_url]').val()
				};
				checkTable(qrInfo, function(result) {
					console.log(result);
					if (result == 'success') {
						console.log('test');
						$('input[name=qrTable_url]').val("branch_num="+qrInfo.branch_num+"&qrtable_num="+qrInfo.qrTable_num);
						$("#operForm").attr("action", "/branch/qr/modify");
						$("#operForm").attr("method", "post");
						$("#operForm").submit();
					} else {
						alert("현재 사용중인 테이블 번호입니다.");
						$('input[name=qrTable_num]').focus();
					}
				});
			});
			
			$("button[data-oper='remove']").on("click", function(e) {
				e.preventDefault();
				$('input[name=qrTable_url]').remove();
				$('input[name=qrTable_num]').remove();
				$("#operForm").attr("action", "/branch/qr/remove");
				$("#operForm").attr("method", "post");
				$("#operForm").submit();
			});
			
			
			$("button[data-oper='list']").on("click", function(e) {
				e.preventDefault();
				$('input[name=qrTable_url]').remove();
				$('input[name=qrTable_num]').remove();
				$('input[name=qrTable_index]').remove();
				$("#operForm").attr("action", "/branch/qr/index");
				$("#operForm").attr("method", "get");
				$("#operForm").submit();
			});

			//중복되는 테이블 확인.
			function checkTable(qrInfo, callback, error) {
				$.ajax({
					type : "put",
					url : "/branch/qr/checkTableNum",
					data : JSON.stringify(qrInfo),
					contentType : "application/json; charset=utf-8",
					success : function(modifyResult, status, xhr) {
						if (callback) {
							callback(modifyResult);
						}
					}
				}); //end ajax
			}
		});
	</script>
</body>

</html>