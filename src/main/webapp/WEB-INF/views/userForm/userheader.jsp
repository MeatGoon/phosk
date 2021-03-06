<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html>
<html>
    <title>Company</title>
<style>
	*{margin: 0 auto; padding: 0px;}
	ul{list-style: none;} /* 리스트 앞에 . 같은거 제거*/
	a{text-decoration: none;} /* 링크에 밑줄 같은거 제거 , 링크 눌러도 검은색*/
	header{
	    width: 100%; /*메인 이미지의 너비 사이즈와 같음*/
	    height: 50px;
	    background-color: #eeccff;
	    position: relative;
	    
	}
   /* 버튼디자인 */
	#header_deja a{
		color : #cc66ff;
	}
	/* 제목영역안에 있는 메인 로고 이미지 위치 지정 */
	#header_logo{
	    position: absolute;
	    top: 10px;
	    left: 2%;
	    font-size : 30px;
	 
	}
	 
	/* 제목영역안에 오른쪽 상단에 top_menu 배치 */
	#header_log{
	    position: absolute;
	    top: 20px;
	    right: 2%;
	} 
	 
	/* 헤더 영역안에 네비게이션 메뉴 배치 */
	nav{
	    position: absolute;
	    top: 30px;
	    right: 250px;
	    font-size: 16px;
	}
	 
	nav li{
	    display: inline;
	    margin-left: 8%;
	}
	 
	
	 
	/* 콘텐츠 영역의 알래에 있는 배너 이미지 inline으로 */
	#header_log li{
	    display: inline;
	    margin-left: 10px;
	    font-size:20px;
	}
	 
	/* 전체 페이지가 가운데로 오도록 */
	#header_page{width: auto; margin: 0px auto;}
</style>
<body>
    
    <div id="header_page">
 
        <header>
        	<div id = "header_deja">
	            <div id="header_logo" >
	                <a href="/user/branchpaging" >PHOSK</a>
	            </div>
	 
	            <div id="header_log">
	            	<%-- member가 없으면 그대로 나옴 로그인 상태가 아닐때 --%>
	                	<c:if test= "${login == null}">
						    <li><a href="/userForm/user/loginpage" role="button">로그인</a></li>&nbsp&nbsp|
						    <li><a href="/userForm/user/register" role="button" >회원가입</a></li>
				        </c:if>
				        <c:if test= "${login != null}">
					        <li><a href="/logout" role="button">로그아웃</a></li>&nbsp&nbsp|
					        <li><a href="/userForm/user/updateuser" role="button">내 정보</a></li>
				        </c:if>
	            </div>
	 
	            <nav>
	                <ul>
	                	<c:if test= "${login != null}">
		                    <li><a href="/userForm/userQNA?member_id=${login.member_id}">QNA</a></li>
		            	 </c:if>
		            	 <c:if test= "${login == null}">
		            	 </c:if>
		            </ul>
	            </nav>
            </div>
        </header>
 
    </div>
</body>
</html>
