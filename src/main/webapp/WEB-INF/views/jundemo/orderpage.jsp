<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<header>
	<jsp:include page="./orderHeader.jsp"/>
</header>




<body>

<%	


int tablenumber = Integer.parseInt(request.getParameter("tablenumber"));


%>

	<div>배정된 테이블 정보: <%= tablenumber%> 번 테이블</div>
	
</body>
</html>