<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%@page import="java.sql.Connection"%>
<%@page import= "java.sql.DriverManager"%>
<%@page import= "java.sql.ResultSet"%>
<%@page import= "java.sql.Statement"%> --%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<input type="button" id=addtablebtn value="테이블 추가" onclick="addtable()"/>


 <table id="table_list">
 
 </table>

<script type="text/javascript">


function addtable(){
	var i = 1;
	var tablenum = i + "번 테이블";
	var tableurl = "http://localhost:8082/jundemo/orderpage?tablenumber="+i;	
	document.getElementById('tbn').value = tablenum;
	document.getElementById('tbu').value = tableurl;
	document.getElementById('updatetable').submit();
	i
}
</script>


<form action="/jundemo/tablesetting/tablesetting" id="updatetable" method="get">
	<input type="hidden" id=tbn value= "" name="tablenumupdb"/>
	<input type="hidden" id=tbu value= "" name="tableurlupdb"/>
</form>









<!--  	const addtable = () => {
		var i = 1;
		var tablelist = document.getElementById("table_list");
		var table_trtd = document.createElement('tr');
		var tablenum_td = table_trtd.appendChild(document.createElement('td'));
		var tableinfo_td = table_trtd.appendChild(document.createElement('td'));
		tablenum_td.id = 'num'+ i +'table'
		tableinfo_td.id = 'num'+i+'info'
		
		tablelist.appendChild(table_trtd);
		
	}  -->
































</body>
</html>