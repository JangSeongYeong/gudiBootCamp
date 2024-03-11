<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// session에 name 이라는 이름으로 "jang, seong-yeong" 이라는 값을 저장한다.
	session.setAttribute("name", "jang, seong-yeong");
	response.sendRedirect("index.jsp");
%>