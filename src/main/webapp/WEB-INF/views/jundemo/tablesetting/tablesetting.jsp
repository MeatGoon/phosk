<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<input type="button" value="테이블 추가" onclick="addtable()"/>

 <table id="table_list">
 
 </table>

<script type="text/javascript">
	const addtable = () => {
		var tablelist = document.getElementById("table_list");
		var table_trtd = document.createElement('tr');
		var table_td = table_trtd.appendChild(document.createElement('td','td'));
		tablelist.appendChild(table_trtd);
	}
</script>




</body>
</html>