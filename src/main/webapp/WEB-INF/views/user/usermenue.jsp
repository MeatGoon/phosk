<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<head>
<meta charset="UTF-8">
<title>온라인 메뉴판</title>
</head>
<style>
#food_bnt{
	color : green;
	 border:none;
	 background: none;
	 padding: 0;
}
</style>
<header>
			<jsp:include page="../userForm/userheader.jsp"/>
</header>
<body>
<h1>온라인 메뉴판입니다</h1>
<p>이름을 클릭하면 상세정보가 나타납니다</p>
<p>미추가 내용 음식클릭시 상세내역 모달창에서 뜨게하기</p>
	<div>
		<form action="">
			<table style = 'float:left; '>	
				<c:forEach items="${catemenulist}" var = "cmenu">
				<c:if test="${branch_num eq cmenu.branch_num}" >
					<tr>
	
						<td style = "font-size: 30px; color : red;"><c:out value="${cmenu.category_name}" /></td>
						<c:forEach items="${itemmenulist}" var = "imenu">
						
						<c:if test="${cmenu.category_num eq imenu.category_num}" >	
						
						<td ><input type="button" value="${imenu.item_name}" id ="food_bnt" />,</td>
						</c:if>
								
						</c:forEach>							
					</tr><br>
				</c:if>	
				</c:forEach>
			</table>
					<div style ='text-align: center;'>
			  			<script>function goBack() {window.history.back();}</script>
						<input type="button" value="테이블 다시선택" onClick= "goBack();" >
					</div>
		</form>
	
	</div>

</body>
</html>