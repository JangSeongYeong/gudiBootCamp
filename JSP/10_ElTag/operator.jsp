<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 사칙연산+mod 연산 -->
	<ul>
		<li>\${5+7} == ${5+7}</li>
		<li>\${8-3} == ${8-3}</li>
		<li>\${6*3} == ${6*3}</li>
		<li>\${9/3} == ${9/3}</li>
		<li>\${9%2} == ${9%2}</li>
	</ul>
	
	<!-- 논리 연산 -->
	<ul>
		<li>\${10 == 9} == ${10 == 9}</li>
		<li>\${10 == 9} == ${10 != 9}</li>
		<li>\${3 < 8} == ${3 < 8}</li>
		<li>\${3 > 8} == ${3 > 8}</li>
		<li>\${3 <= 8} == ${3 <= 8}</li>
		<li>\${3 >= 8} == ${3 >= 8}</li>
		<br/>
		<!-- 부등호가 태그와 헷갈릴 수 있어 문자로 대체 가능 -->
		<li>\${10 eq 9} == ${10 eq 9}</li>
		<li>\${10 ne 9} == ${10 ne 9}</li>
		<li>\${3 lt 8} == ${3 lt 8}</li>
		<li>\${3 gt 8} == ${3 gt 8}</li>
		<li>\${3 le 8} == ${3 le 8}</li>
		<li>\${3 ge 8} == ${3 ge 8}</li>
	</ul>
	
	<!-- 삼항 연산 -->
	\${5+3==8?1:0} == ${5+3==8?1:0}
</body>
</html>