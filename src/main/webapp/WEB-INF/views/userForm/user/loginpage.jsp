<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
		<jsp:include page="../userheader.jsp"/>
</head>
	<body>	

    	<fieldset class="logForm" >
    		<form action="/userForm/user/loginpage" method = "post">
	     	<c:if test="${login == null}">
	     	<div class="login_main" >	     	
		      	<div class="login_insert">		      	
			        <div class="login_id">
				        <label for="loginId" class="screen_out"></label>
				        <input type="text" id="member_id" name="member_id" placeholder="ID" >
			        </div>
			        <div class="login_pwd">
				        <label for="loginPw" class="screen_out"></label>
				        <input type="password" id="member_pwd" name="member_pwd" placeholder="Password" >
			        </div>
		       </div>

		        	<button  class="btn_login" type="submit" >로그인</button>	
		  
		      </div>
	      	<div class="login_ano">
		        <div class="login_chk"> <!-- 체크시 checked 추가 -->
			        <input type="checkbox" id="keepLogin" class="inp_radio"  name="keepLogin">
			        <label for="keepLogin" class="lab_g">
						<span class="img_top ico_check"></span>
						<span class="txt_lab">로그인 상태 유지</span>
					</label>
		        </div>
		        <span class="login_find">
		        	<a href="/userForm/usertest" class="link_find">아이디</a> / <a href="/userForm/usertest" class="link_find">비밀번호 찾기</a>
		        </span>
	      	</div>
	      	</c:if>
	      	<c:if test="${login != null }">
			<div>
			
				<p>${login.member_id}님 환영 합니다.</p>
				<button type="button" onclick="location.href='/logout' ">로그아웃</button>
			</div>
		</c:if>      	
	      </form>	      
   	 	</fieldset>
	</body> 
</html>