<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴옵션 등록페이지</title>
</head>
<body>
<form>
<section>
	<ul>
		<li>메뉴 사이즈 옵션</li>
	</ul>
	<ul>
		<li><p>사이즈1<input  id="basic_option1" type="text" value="예: 사이즈(대)"></p></li>
		<li><p>가격<input id="basic_price1" type="number" value="1000-999999" min="1000" max="999999"></p></li>
	</ul>
	<ul>
		<li><p>사이즈2<input id="basic_option2" type="text" value="예: 사이즈(중)"></p></li>
		<li><p>가격<input id="basic_price2" type="number" value="1000-999999" min="1000" max="999999"></p></li>
	</ul>
	<ul>
		<li><p>사이즈3<input id="basic_option3" type="text" value="예: 사이즈(소)"></p></li>
		<li><p>가격<input id="basic_price3" type="number" value="1000-999999" min="1000" max="999999"></p></li>
	</ul>
	<ul>
		<li><p>사이즈4<input id="basic_option4" type="text" value="예: 사이즈(기타)"></p></li>
		<li><p>가격<input id="basic_price4" type="number" value="1000-999999" min="1000" max="999999"></p></li>
	</ul>
</section>

<section>
	<ul>
		<li>메뉴 추가 옵션</li>
	</ul>
	<ul>
		<li><p>추가옵션1<input id="add_option1" type="text" value="예: 추가옵션1"></p></li>
		<li><p>가격<input id="add_price1" type="number" value="100-9999" min="100" max="9999"></p></li>
	</ul>
	<ul>
		<li><p>추가옵션2<input id="add_option2" type="text" value="예: 추가옵션2"></p></li>
		<li><p>가격<input id="add_price2" type="number" value="100-9999" min="100" max="9999"></p></li>
	</ul>
		<ul>
		<li><p>추가옵션3<input id="add_option3" type="text" value="예: 추가옵션3"></p></li>
		<li><p>가격<input id="add_price3" type="number" value="100-9999" min="100" max="9999"></p></li>
	</ul>
		<ul>
		<li><p>추가옵션4<input id="add_option4" type="text" value="예: 추가옵션4"></p></li>
		<li><p>가격<input id="add_price4" type="number" value="100-9999" min="100" max="9999"></p></li>
	</ul>
</section>

<input type="submit">
<a>취소</a>

</form>
</body>
</html>