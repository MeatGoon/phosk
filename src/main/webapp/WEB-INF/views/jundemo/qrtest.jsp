<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<script src="http://code.jquery.com/jquery-latest.js"></script> 
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>egovTest</title>
    <script type="text/javaScript" language="javascript" defer="defer">
    
    
        $(document).ready(function(){
            $("#execute").click(function(){
                url = "/createCode.do";
                var content = $("#content").val();
          
                $("#img").attr("src", url+"?content="+content);
                
            });
        });
        
    </script>
</head>
<body>
    <h1>zxing Code Test</h1>
        
    <div>
        <input id="content" type="text" name="content"/>
        <input type="button" id="execute" value="QR코드생성"/>
        <img id="img" style="display:none" onload="this.style.display='block'"/>
    </div>
</body>
</html>