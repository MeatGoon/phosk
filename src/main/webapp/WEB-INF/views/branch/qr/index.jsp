<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QR table info</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/qrcode.js"></script>
</head>
<header>
		<jsp:include page="../../onerHeader.jsp"/>
</header>
<body>
	<button type="button" id="register">QR 등록하기</button>
   <c:forEach items="${qrList}" var="qr" varStatus="status">
      <div>
         <div id="qrcode_${qr.qrTable_num}" style="margin:auto; margin-top:15px;">
            <span>${qr.qrTable_num} 번 테이블 QR</span>
            <input type="text" name="branch_num" value="${qr.branch_num}" readonly="readonly">
            <input type="text" name="qrTable_num" value="${qr.qrTable_num}" readonly="readonly">
            <!-- 꼭 바꿔야함. -->
            <input type="hidden" name="qrTable_url" id="url_${qr.qrTable_num}" value="http://localhost/branch/qr/index?${qr.qrTable_url}">
         </div>
         <c:if test="${qr.qrTable_url != null}">
            <button class="detail">상세보기</button>
         </c:if>
      </div>
   </c:forEach>
   <form id="actionForm"></form>
<script type="text/javascript">
$(document).ready(function () {

	var result = '<c:out value="${result}"/>';
	var executions = '<c:out value="${executions}"/>';
	checkMessage(result,executions);
	//뭔가 작업후 이전페이지 갈때 반복안되게..예 : 등록후 이전페이지 클릭시 도배되는 문제를 막음.
	history.replaceState({},null,null);
	
	function checkMessage(result , executions) {
		if(result === '' || history.state){
			return;			
		}else if (result == 'success'){
			alert(executions + "를(을) 성공 하였습니다.");		
		}else{
			alert(executions + "를(을) 실패 하였습니다.");
		}
	}
	
   //전체 인덱스 읽어옴
   var index = "${fn:length(qrList)}";
   var qrTableNumArr = ${qrTableNumArr};
   for (var i = 0; i < index; i++) {
      console.log(qrTableNumArr[i]);
      //qr코드 생성
      var qrcode = new QRCode(document.getElementById("qrcode_"+qrTableNumArr[i]), {
         //가로, 세로 높이 조절
         width : 100,
         height : 100
      });
      
      //input:text에 들어있는 value를 qr코드로 바꿔주는 function
      function makeCode () {      
         var elText = document.getElementById("url_"+qrTableNumArr[i]);
         
         //value가 비어있으면
         if (!elText.value) {
            return;
         }else{
            qrcode.makeCode(elText.value);
         } 
      }
      makeCode();
   }
   
   
   var actionForm = $('#actionForm');
   //QR상세보기.
   //$('button[name="modify"]').on('click', function() {
	$('.detail').on('click', function(e) {
		e.preventDefault();
		var detail_branch_num = $(this).prev().children('input:eq(0)').val();
		var detail_qr_table_num = $(this).prev().children('input:eq(1)').val();
		actionForm.append("<input type='hidden' name='branch_num' value='"+detail_branch_num+"'/>");
		actionForm.append("<input type='hidden' name='qrTable_num' value='"+detail_qr_table_num+"'/>");
		actionForm.attr("action" , "/branch/qr/detail");
		actionForm.submit();
      	//$(this).prev().children('input').css({"border": "2px solid red"});
      	//console.log($(this).prev().children('input').val());
      	//console.log($(this).prev().children('input:eq(0)').val());
      	//console.log($(this).prev().children('input:eq(1)').val());
	});
	
	
	$('#register').on("click", function(e) {
		e.preventDefault();
		var branch_num = '<c:out value="${qrInfo.branch_num}"/>';
		actionForm.append("<input type='hidden' name='branch_num' value='"+branch_num+"'/>");
		actionForm.attr("action" , "/branch/qr/register");
		actionForm.submit();
	});
   
});
</script>
</body>

