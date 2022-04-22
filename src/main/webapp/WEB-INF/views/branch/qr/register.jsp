<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<header>
		<jsp:include page="../../onerHeader.jsp"/>
</header>
<body>
	<div>
		<div id="qrcode">
			<input type="hidden" id="url">
		</div>
		<div style="margin: auto; margin-left: 15px;">
			<form id="operForm">
				<label for="branch_num">사업자 번호 : </label><input type="text" name="branch_num" value="${branchNum}" readonly="readonly"><br />
				<label for="qrTable_url">등록될 URL : </label><input type="text" name="qrTable_url" readonly="readonly"  ><br />
				<label for="qrTable_num">등록하실 테이블 번호 : </label><input type="text" name="qrTable_num" ><br />
				
				<button id="insert" data-oper="insert">등록</button>
				<button type="reset" >취소</button>
				<button type="submit" data-oper="list">목록</button>
			</form>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
	
	$(document).ready(function() {
		var table_num_flag = false;
		var table_num = $("input[name='qrTable_num']");
		var branch_num = $("input[name='branch_num']");
		var qrTable_url = $("input[name='qrTable_url']");
		var insert_btn = document.getElementById('insert');
		insert_btn.disabled = true;
		
		
		$(table_num).blur(function() {
			checkInputData("등록할 테이블 번호를 입력하세요." , table_num);
			console.log(table_num_flag);
			if(table_num_flag == false){
				qrTable_url.val("branch_num="+branch_num.val()+"&qrtable_num="+table_num.val());
				insert_btn.disabled = false;
			}
		});
		
		
		$("button[data-oper='insert']").on("click", function(e) {
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
						$("#operForm").attr("action", "/branch/qr/register");
						$("#operForm").attr("method", "post");
						$("#operForm").submit();
					} else {
						alert("현재 사용중인 테이블 번호입니다.");
						$('input[name=qrTable_num]').focus();
					}
				});
		});
		function checkTable(qrInfo, callback, error) {
			$.ajax({
				type : "put",
				url : "/branch/qr/checkTableNum",
				data : JSON.stringify(qrInfo),
				contentType : "application/json; charset=utf-8",
				success : function(result, status, xhr) {
					if (callback) {
						callback(result);
					}
				}
			}); //end ajax
		}
		
		
		$("button[data-oper='list']").on("click", function(e) {
			e.preventDefault();
			$('input[name=qrTable_url]').remove();
			$('input[name=qrTable_num]').remove();
			$("#operForm").attr("action", "/branch/qr/index");
			$("#operForm").attr("method", "get");
			$("#operForm").submit();
		});
		
		function checkInputData(text,data) {
			if(data.val() == "" && table_num_flag == false){
				data.after("<p style='color:red'>"+text+"</p>");
				table_num_flag = true;
				insert_btn.disabled = true;
				return false;
			}else if(data.val() != "" && table_num_flag == true){
				data.next().remove();
				table_num_flag = false;
				return true;
			}
		}
	});
	</script>
</body>
</html>