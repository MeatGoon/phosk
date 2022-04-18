<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<head>
	<title>카드정보 등록</title>
</head>
<header>
			<jsp:include page="../userheader.jsp"/>
</header>
<script type="text/javascript">
		
	$(function(){		
	$(".cardinfo_btn2").on("click", function(){
					if(card.cardinfo_bank.value== "은행선택"){
						alert("은행을 선택해주세요.");
						card.cardinfo_bank.focus();
						return false;
					}
					if($("#cardinfo_holderName").val()==""){
						alert("이름을 입력해주세요.");
						$("#cardinfo_holderName").focus();
						return false;
					}
					if($("#cardinfo_cardNum").val()==""){
						alert("카드번호를 입력해주세요.");
						$("#cardinfo_cardNum").focus();
						return false;
					}
					if($("#cardinfo_dealine").val()==""){
						alert("종료날짜를 입력해주세요.");
						$("#cardinfo_dealine").focus();
						return false;
					}
					if($("#cardinfo_cardCVC").val()==""){
						alert("CVC을 입력해주세요.");
						$("#cardinfo_cardCVC").focus();
						return false;
					}
					if($("#cardinfo_accountpwd").val()==""){
						alert("비밀번호를 입력해주세요.");
						$("#cardinfo_accountpwd").focus();
						return false;
					}
					if($("#cardinfo_cardpwd").val()==""){
						alert("카드비밀번호를 입력해주세요.");
						$("#cardinfo_cardpwd").focus();
						return false;
					}
		});
	
	});
	 function maxLengthCheck(object){
		    if (object.value.length > object.maxLength){
		      //object.maxLength : 매게변수 오브젝트의 maxlength 속성 값입니다.
		      //숫자가 maxlength에 먹히지않아 추가	
		      object.value = object.value.slice(0, object.maxLength);
		    }    
		  }
		  
	</script>
<body>
	<div class="container">
		<form method= "post" action="/userForm/cardinfo/cardinfoForm" name= "card">
		<c:if test="${login != null }">	
			<table class= "cardinfo_insert" >
				<thead>
					<tr>
						<th><h2>카드등록테스트</h2></th>
					</tr>
				</thead>
				<tbody class="cardinfo_body">					
					<tr> 
						<th> 
							<select id="cardinfo_bank" name="cardinfo_bank" style="width:200px;">	
								<option selected disabled>은행선택</option>													
								<option value="신한은행">신한은행</option>
								<option value="국민은행">국민은행</option>
								<option value="수협은행">수협은행</option>
								<option value="농협은행">농협은행</option>
								<option value="기업은행">기업은행</option>
								<option value="부산은행">부산은행</option>
								
							</select>
						</th> 
					</tr> 
					<tr>
						<td><input class="form" type="hidden" id="member_id" name="member_id" value="${login.member_id}" /></td>
					</tr>
					<tr>
						<td><input class="form" type="text" id = "cardinfo_holderName" name ="cardinfo_holderName"  placeholder="사용자이름" maxLength="50" oninput="maxLengthCheck(this)"/></td>
					</tr>
					<tr> 
						<td><input class="form" type="number" id = "cardinfo_cardNum" name =cardinfo_cardNum  placeholder="카드번호" maxLength="19" oninput="maxLengthCheck(this)"/></td>
					</tr>
					<tr>
						<td><input class="form" type="number" id = "cardinfo_dealine" name ="cardinfo_dealine" placeholder="만기일" maxLength="5" oninput="maxLengthCheck(this)"/></td>
					</tr>
					<tr>
						<td><input class="form" type="number" id = "cardinfo_cardCVC" name ="cardinfo_cardCVC"  placeholder="cvc" maxLength="3" oninput="maxLengthCheck(this)"/></td>
					</tr>	
					<tr>
						<td><input class="form" type="number" id = "cardinfo_accountpwd" name ="cardinfo_accountpwd"  placeholder="어플비밀번호" maxLength="6" oninput="maxLengthCheck(this)"/></td>
					</tr>
					<tr>
						<td><input class="form" type="number" id = "cardinfo_cardpwd" name ="cardinfo_cardpwd"  placeholder="카드비밀번호" maxLength="4" oninput="maxLengthCheck(this)"/></td>
					</tr>
																		
				</tbody>
				<tfoot  class="cardinfo_btn">
					<tr>
						<td>  
							<script>function goBack() {window.history.back();}</script>
					        <input class="cardinfo_btn1" type="button" value="취소" onClick= "goBack();">
					        <input class="cardinfo_btn2" type="submit" value="카드등록">   
	  					</td>
	  					
  					</tr>
  				</tfoot>	
			</table>
		</c:if>
		<c:if test="${login == null}">
		 <h2>로그인을 실행해주세요</h2>
		</c:if>
		</form>
	</div>	
</body>
</html>