<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 세션 초기화의 경우에는 완전히 다른 세선을 받기 때문에 세션 아이디가 변경되어 있다. */
	session.invalidate();
	response.sendRedirect("index.jsp");
%>