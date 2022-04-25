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
	#paging_deja a{
		font-size : 25px;
		float : left;
		border : 1px solid black;
		width : 25px;
		text-align :center;
	}
	#paging_deja{
		margin-left : 47%;
	}

</style>
<header>
	<jsp:include page="../userForm/userheader.jsp"/>
</header>
<body>
	<div class= "usermain_haed">
		<form action="/user/branchpaging" method = "get">
		
			<div class="search" style = 'text-align :center;'>
                <input type="text" value = "미구현">
                <button type="button">검색</button>
            </div> 
			<table  id ="usermain_branch">
				<tr style = 'color : blue;'><th>지점명</th><th>위치</th><th>전화번호</th></tr>
				<c:forEach items="${list}" var = "page">
					<tr>	
						<td><c:out value="${page.branch_name}" /></td>						
						<td><c:out value="${page.branch_detail}" /></td>								
						<td><c:out value="${page.branch_phone}" /></td>	
						<td><button type="button" onclick="location.href='/user/tablechoice?branch_num=${page.branch_num}'">이동</button></td>																		
					</tr>
				</c:forEach>
			</table>		
				<p style = "text-align: center">==========페이징 파트==========</p>				
			<div id = paging_deja>
				 <ul >
				  <c:if test="${pagemaker.prev}">
				   <li><a href="branchpaging${pagemaker.makeQuery(pagemaker.startPage - 1)}"  >이전</a></li>
				  </c:if> 
				  
				  <c:forEach begin="${pagemaker.startPage}" end="${pagemaker.endPage}" var="idx">
				   <li><a href="branchpaging${pagemaker.makeQuery(idx)}" >${idx}</a></li>
				  </c:forEach>
				    
				  <c:if test="${pagemaker.next && pagemaker.endPage > 0}">
				   <li><a href="branchpaging${pagemaker.makeQuery(pagemaker.endPage + 1)}" >다음</a></li>
				  </c:if> 
				 </ul>
			</div> 
		</form>	
	</div>
</body>
</html>