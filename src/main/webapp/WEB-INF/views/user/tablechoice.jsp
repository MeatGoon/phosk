<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>choice table</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/qrcode.js"></script>
</head>
<header>
			<jsp:include page="../userForm/userheader.jsp"/>
</header>
<body>

 <div>
	<h1  style= ' text-align: center;'>테이블선택화면</h1>
	<form action="/user/tablechoice" method="get">
			<p>시간부족으로 일단 글로 설명 if를 이용하여 같은가게 정보만 보이게 실행 현제 그냥 나옴</p>
		<table style ='border: 1px solid pink;'>
			<tr><th>테이블번호</th><th>지점번호</th><th>메뉴주문</th></tr>	
				<c:forEach items="${qrlist}" var="qr">	
					<tr>
						<td><c:out value="${qr.qrTable_num}" /></td>
						<td><c:out value="${qr.branch_num}" /></td>
						<td><input type="hidden" value="<c:out value="${qr.qrTable_url}" />">
							<input type="button" value= "메뉴판보기" onclick="location.href='/user/usermenue?branch_name=${branch_name}&qrtable_num=${qr.qrTable_num }'"/>
						</td>
					</tr> 
  				</c:forEach>
		</table>
				<div style ='text-align: center;'>
  				<script>function goBack() {window.history.back();}</script>
				<input  type="button" value="뒤로가기" onClick= "goBack();">
				</div>
	</form>		
</div>		
 </body>
 </html>
   