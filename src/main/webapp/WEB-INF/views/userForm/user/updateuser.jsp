<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!DOCTYPE html>
<html>
	<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<head>
		<title>회원 정보수정</title>
</head>
<style>

	#container{
		border : 5px solid black;
		width : 35%;
		margin:auto ;
		margin-top : 10%; 
	}
		.update_userlist{
		text-align: center;
		margin : 10%;
	}
	.user_card{
		text-align: center;
	}
	.updata_bottom{
		margin: 10%;
	}
	.card_infor{
		display : flex;
		margin : auto;
	}
	#plus_btn{
		width : 80px;
		height : 80px;
	}
</style>
<header>
			<jsp:include page="../userheader.jsp"/>
</header>
	<script type="text/javascript">
		$(function(){					
			// 취소
			$(".cencle").on("click", function(){
				location.href = "/user/branchpaging";						    
			});		
			$("#editt").on("click", function(){		
				if($("#member_pwd").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#member_pwd").focus();
					return false;
				}
				});			
			})
	
	//카드 전체삭제시 안내말 +만약 회원탈퇴시 카드정보가 있으면 카드삭제로 focus 주기 
	</script>
	<body>
		<div id="container">
			<form action="/userForm/user/updateuser" method="post" class= "update_userlist">						
				<div class="form-group">
					<label class="user_id" for="member_id" ></label>
					<input class="user_id" type="hidden" id="member_id" name="member_id" value="${login.member_id}"  readonly="readonly"/>
				</div>
						
				<div class="change_pw">
					<label class="user_pw" for="member_pwd"></label>
					<input class="user_pw" type="password" id="member_pwd" name="member_pwd" placeholder="비밀번호 변경" />
				</div>
						
				<div class="form-group">
					<button class="btn" type="submit" id="editt">회원정보수정</button>
					<button class="cencle" type="button">취소</button>
				</div>
			</form>
			<form class = "change_line" autocomplete="off" method = "post" action="/delete/userdel">
					<div class= "user_card" >
						<div class = "card_infor">
							<c:if test="${login != null }" >
								<table style ='border : 1px solid red; '>
											<tr><th>은행사</th><th>카드번호</th><th>카드주</th></tr>		
									<c:forEach items="${mycard}" var = "list" >
										<c:if test="${list.member_id eq login.member_id}" >													
											<tr >	
											<td><c:out value="${list.cardinfo_bank}" /></td>						
											<td><c:out value="${list.cardinfo_cardNum}" /></td>								
											<td><c:out value="${list.cardinfo_holderName}" /></td>	
											<td><input  type="hidden" id="cardinfo_cardNum" name="cardinfo_cardNum" value="${list.cardinfo_cardNum}" /></td>									
											<td><button type="submit"  onclick="javascript: form.action='/delete/carddel';">카드삭제</button></td>										
											</tr>
			
										</c:if>	
									</c:forEach>
										<tr>
											<!-- 회원탈퇴랑 공통사용 -->
											<td><input  type="hidden" id="member_id" name="member_id" value="${login.member_id}" /></td>
											<td><button type="submit" class= "carddel_bnt"   onClick = "javascript: form.action='/delete/cardall';" >카드전체삭제</button></td>	
										</tr>
								</table>
							</c:if>
							<div class = "plus_card">
								<input id = "plus_btn" type="button" value="카드등록" onClick = "location.href='/userForm/cardinfo/cardinfoForm'"><br>	
							</div>
						</div>	
							<div class = "updata_bottom">
								<input type="submit" id = "userdel_btn" value="회원탈퇴" >
								<script>function goBack() {window.history.back();}</script>
					        	<input class="non_update" type="button" value="뒤로가기" onClick= "goBack();">
								<!-- <input type="submit" id = "userdel_btn"value="회원탈퇴" onClick = "javascript: form.action='/delete/userdel';"> -->															
							</div>
							<c:forEach items="${mycard}" var = "list" >
							<c:if test="${list.member_id eq login.member_id}" >	
							
							
							<script>	
							$(function(){					
								$("#userdel_btn").on("click", function(){
					
									if(${list.member_id eq null}){
											
										}else{
											alert("카드전체삭제를 먼저 진행해주세요");	
											return false;
										}
									});
								}) 
	
														
							</script>
							</c:if>	
							</c:forEach>
					</div>
				</form>
		</div>
		
	</body>
	
	
</html>