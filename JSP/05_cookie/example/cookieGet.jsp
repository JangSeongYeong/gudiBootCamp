<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String val = "";
	// 1. 쿠키 들을 가져온다.
	Cookie[] cookies = request.getCookies();
	// 2. 쿠키들 중에서 이름이 lang 인 녀석을 찾는다.
	for(Cookie c : cookies){
		if(c.getName().equals("lang")){
			val = c.getValue();
			// 쿠키 삭제 (0초만 살도록 변경)
			c.setMaxAge(0);
			response.addCookie(c);
			break;
		}
	}
	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 3. lang 의 값에 따라서 환영 문구를 다르게 해준다.  --> 
	<%
		if(val.equals("kor")){
	%>
			<h3>한글 페이지에 오신 것을 환영합니다.</h3>			
	<%
		} else{
	%>
			<h3>Welcome to English Page!!</h3>
	<%}%>
</body>
</html>