<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 받아온 값을 쿠키에 저장(이름 : lang, 값 : 받아온 값)
	String lang = request.getParameter("lang");
	System.out.println(lang);
	
	lang = lang == null? "kor":lang; // null 처리(null 로 들어왔을 경우 어떻게 할 것인가?)
	
	// 1-1 쿠키 객체 생성
	Cookie cookie = new Cookie("lang", lang);

	// 1-2 쿠키 수명
	cookie.setMaxAge(60*60*24);
	
	// 1-3 response 객체로 지정
 	response.addCookie(cookie);	
	
 	// 2. cookieGet.jsp 로 이동
	response.sendRedirect("cookieGet.jsp");
	
%>