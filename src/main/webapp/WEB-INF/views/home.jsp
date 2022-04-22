<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	<h2><a href = "/branch/main/index?branch_num="  style=' color:red;'>지점메인메뉴</a></h2>
	<h2><a href = "/user/branchpaging"  style=' color:blue;'>유저메인메뉴</a></h2>
</body>
</html>
