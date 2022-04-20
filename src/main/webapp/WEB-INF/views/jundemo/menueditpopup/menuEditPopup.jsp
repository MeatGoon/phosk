<%@page import="org.omg.CORBA.PUBLIC_MEMBER"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 등록 페이지</title>
<script language="javascript">
	function showmenueditoptionPopup() {
		window.open("./menuEditOptionPopup", "",
				"width=400, height=800, left=100, top=50");
	}
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/resources/css/menuedit.css">
<%-- <script src="${path}/resources/js/menuedit.js"></script> --%>
</head>
<body>
	<h1>메뉴등록페이지</h1>
	<form method="post" enctype="multipart/form-data">
		<a>취소</a> <input type="submit">
		<ul>
			<li>메뉴정보</li>
		</ul>
		<p>
			메뉴명: <input type="text">
		</p>
		<p>
			가격: <input type="text">
		</p>
		<ul>
			<li>제품구성</li>
		</ul>
		<input type="text" value="한우/트러플/갈릭/파슬리">
		<ul>
			<li>상세설명</li>
		</ul>
		<input type="text" value="1분간 드라이 숙성시킨 한우">
		<ul>
			<li><input type="button" value="추가옵션 등록" id="btnOpen">
				<div id="optionmodal">
					<div id="content">
						<input type='button' value='X' class="optionclosept"
							id="optionbtnClose" />
						<p>메뉴옵션 등록</p>

						<form action="/jundemo/menueditpopup/menuEditPopup" method="post">
							<table>
								<tr>
									<td><label>사이즈 옵션:</label></td>
									<td><input type="text" id="basic_option" name="basic_option" /></td>
								</tr>
								<tr>
									<td><label>가격 입력:</label></td>
									<td><input type="number" id="basic_price"
										name="basic_price" /></td>
								</tr>
							</table>
							<input type="button" value="추가" onclick="printbasic_optionName()"><br />












							<!-- -------------------------------------추가옵션 등록 구간-------------------------------------------------->


							<input type="button" value="추가옵션입력창 열기" Id="addopbtn"
								onclick="ShowHide(this)" />
							<script>
								function ShowHide(self) {
									var target = document
											.getElementById("addoption");
									if (self.value === "추가옵션입력창 열기") {
										target.style.display = "block";
										self.value = "추가옵션입력창 닫기";
									} else {
										target.style.display = "none";
										self.value = "추가옵션입력창 열기";
									}
								}
							</script>



							<div id="addoption" style="display: none;">
								<p>추가옵션 등록</p>
								<table>
									<tr>
										<td><label>추가 옵션:</label></td>
										<td><input type="text" id="side_option"
											name="add_option1" /></td>
									</tr>
									<tr>
										<td><label>가격 입력:</label></td>
										<td><input type="number" id="side_price"
											name="add_price1" /></td>
									</tr>
								</table>
								<input type="button" value="추가" onclick="printside_optionName()" />



							</div>
						</form>

						<!-- ----------------------------------------------------------------------------------------------------->






						<!-- 					<script>
						const printbasic_optionName = () => {
							var basic_option = document.getElementById('basic_option').value;
							var basic_price = document.getElementById('basic_price').value;
							var basicoptionList = document.getElementById("boList");
							var basicP = document.createElement('p');
							basicP.className = 'bolistname'
							basicP.innerHTML = basic_option + basic_price + "원" + "<input type='button' value='삭제' class='hidden' onclick='remove(this)'>";
							basicoptionList.appendChild(basicP);
							document.getElementById('basic_option').value=null;
							document.getElementById('basic_price').value=null;
							
						}
						const remove = (obj) => {
							document.getElementById('boList').removeChild(obj.parentNode);
						}
						

						const printside_optionName = () => {
							var side_option = document.getElementById('side_option').value;
							var side_price = document.getElementById('side_price').value;
							var sideoptionList = document.getElementById("sideList");
							var sideP = document.createElement('p');
							sideP.className = 'sidelistname'
							sideP.innerHTML = side_option + side_price + "원" + "<input type='button' value='삭제' class='hidden' onclick='del(this)'>";
							sideoptionList.appendChild(sideP);
							document.getElementById('side_option').value=null;
							document.getElementById('side_price').value=null;
							
						}
						const del = (obj) => {
							document.getElementById('sideList').removeChild(obj.parentNode);
						}
						
					</script> -->


						<table border='1'>
							<tr>
								<th>
									<div id="boList" class="boc">사이즈 리스트</div>
								</th>
							</tr>
							<tr>
								<th>
									<div id="sideList" class="soc">추가 옵션 리스트</div>
								</th>
							</tr>
						</table>





						<!-- ------------------------------------------------------------------------------------------------------------------------------ -->


						<input type="button" value="확인" id="btnCheck" />

					</div>
				</div> <script>
					var btnOpen = document.getElementById("btnOpen");
					var btnCheck = document.getElementById("btnCheck");
					var btnClose = document.getElementById("optionbtnClose");

					// modal 창을 닫기
					var closeRtn = function() {
						var optionmodal = document
								.getElementById("optionmodal");
						optionmodal.style.display = "none";
						addopbtn.value = "추가옵션입력창 열기";
						addoption.style.display = "none";
					}

					// modal 창을 열기
					btnOpen.onclick = function() {
						var optionmodal = document
								.getElementById('optionmodal');
						optionmodal.style.display = 'block';
					}

					//확인버튼 옵션선택내용 출력
					btnCheck.onclick = function() {
						var optionmodal = document
								.getElementById("optionmodal");
						optionmodal.style.display = "none";
						addopbtn.value = "추가옵션입력창 열기";
						addoption.style.display = "none";
					}

					btnClose.onclick = closeRtn;
				</script></li>
		</ul>
		<ul>
			<li>상품이미지</li>
		</ul>
		<input type="file" name="profile">



		<div id="bolist2" class="boc2"></div>




		<div id="sideList2" class="soc2"></div>










	</form>


</body>
</html>