<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<head>
		<jsp:include page="../userheader.jsp"/>
</head>
<body>
	<div class="container">
		<form method= "post" action="/userForm/cardinfo/cardinfoForm">
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
						<td><input class="form" type="text" id = "cardinfo_holderName" name ="cardinfo_holderName"  placeholder="사용자이름" maxLength="50"/></td>
					</tr>
					<tr>
						<td><input class="form" type="text" id = "cardinfo_cardNum" name =cardinfo_cardNum  placeholder="카드번호" maxLength="19"/></td>
					</tr>
					<tr>
						<td><input class="form" type="text" id = "cardinfo_dealine" name ="cardinfo_dealine" placeholder="만기일" maxLength="5"/></td>
					</tr>
					<tr>
						<td><input class="form" type="text" id = "cardinfo_cardCVC" name ="cardinfo_cardCVC"  placeholder="cvc" maxLength="3"/></td>
					</tr>	
					<tr>
						<td><input class="form" type="text" id = "cardinfo_accountpwd" name ="cardinfo_accountpwd"  placeholder="어플비밀번호" maxLength="6"/></td>
					</tr>
					<tr>
						<td><input class="form" type="text" id = "cardinfo_cardpwd" name ="cardinfo_cardpwd"  placeholder="카드비밀번호" maxLength="4"/></td>
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
		</form>
	</div>	
</body>
</html>