<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html>
<html>
    <title>Company</title>
<style>
*{margin: 0 auto; padding: 0px;}
ul{list-style: none;} /* 리스트 앞에 . 같은거 제거*/
a{text-decoration: none; color: #cc66ff} /* 링크에 밑줄 같은거 제거 , 링크 눌러도 검은색*/
 
header{
    width: 100%; /*메인 이미지의 너비 사이즈와 같음*/
    height: 50px;
    background-color: #eeccff;
    position: relative;
}
/* 제목영역안에 있는 메인 로고 이미지 위치 지정 */
#header_logo{
    position: absolute;
    top: 10px;
    left: 30px;
    font-size : 30px;
 
}
 
/* 제목영역안에 오른쪽 상단에 top_menu 배치 */
#header_log{
    position: absolute;
    top: 20px;
    right: 10px;
}
 
/* top_menu a의 글시 하얀색으로 */
#header_log a{}
nav li a{}
 
/* 헤더 영역안에 네비게이션 메뉴 배치 */
nav{
    position: absolute;
    top: 30px;
    right: 250px;
    font-size: 16px;
}
 
nav li{
    display: inline;
    margin-left: 30px;
}
 

 
/* 콘텐츠 영역의 알래에 있는 배너 이미지 inline으로 */
#header_log li{
    display: inline;
    margin-left: 15px;
    font-size:12px;
}
 
/* 전체 페이지가 가운데로 오도록 */
#header_page{width: 820px; margin: 0px auto;}
</style>
<head>
 

</head>
<body>
    
    <div id="header_page">
 
        <header>
            <div id="header_logo" >
                <a href="/userForm/usertest">PHOSK</a>
            </div>
 
            <div id="header_log">
            	<%-- member가 없으면 그대로 나옴 로그인 상태가 아닐때 --%>
                	<c:if test= "${login == null}">
					    <li><a href="/userForm/user/loginpage" role="button">로그인</a></li>
					    <li><a href="/userForm/user/register" role="button">회원가입</a></li>
			        </c:if>
			        <c:if test= "${login != null}">
				        <li><a href="/userForm/usertest" role="button">로그아웃</a></li>
				        <li><a href="/userForm/user/updateuser" role="button">내 정보</a></li>
			        </c:if>
            </div>
 
            <nav>
                <ul>
	                    <li><a href="/userForm/userQNA">QNA</a></li>
	            </ul>
            </nav>
        </header>
 
    </div>
</body>
</html>
