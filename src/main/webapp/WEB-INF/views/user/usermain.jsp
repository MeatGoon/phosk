<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.usermain_haed{
		margin-top : 100px;
	}
	#usermain_branch{
		margin-top : 5%;
		width : 60%;
		height : auto;
		border : 1px solid blue;
		text-align :center;
	}

</style>
<header>
	<jsp:include page="../userForm/userheader.jsp"/>
</header>
<body>
	<div class= "usermain_haed">
		<form action="/user/usermain" method = "get">
		
			<div class="search" style = 'text-align :center;'>
                <input type="text">
                <button type="button">검색</button>
            </div> 
			<table  id ="usermain_branch">
				<tr style = 'color : blue;'><th>지점명</th><th>위치</th><th>전화번호</th></tr>
				<c:forEach items="${branchlist}" var = "list">
					<tr>	
						<td><c:out value="${list.branch_name}" /></td>						
						<td><c:out value="${list.branch_detail}" /></td>								
						<td><c:out value="${list.branch_phone}" /></td>	
						<td><button type="button" onclick="location.href='/branch/main/index?branch_name=${list.branch_name}'">이동</button></td>													
					</tr>
				</c:forEach>
			</table>		
			<div>
			<p>페이징만 추가</p>
			</div>	
		</form>	
	</div>
</body>
</html>