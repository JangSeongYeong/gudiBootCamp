<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
 	// cookie : PC 에 저장되므로 resp 로 저장하고 req 가져온다.
 	// 1. 쿠키 객체화 (값에 , 나 - 가 있으면 에러가 난다.)
 	Cookie cookie = new Cookie("name","jang_seong_yeong"); //key-value
 	
 	// 2. 쿠키 수명 지정
 	cookie.setMaxAge(10*60);// 초 단위
 	
 	// 3. 쿠키를 클라이언트(사용자PC)에 저장
 	response.addCookie(cookie);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="쿠키 불러오기" onclick="location.href='cookieResult.jsp'"/>
	<input type="button" value="쿠키 예제" onclick="location.href='example/infoInput.jsp'"/>
</body>
</html>