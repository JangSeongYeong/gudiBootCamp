<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// loginId 라는 속성이 로그인한 증표가 되므로 이 속성을 지워준다.
	session.removeAttribute("loginId");
	response.sendRedirect("./login.jsp");
%>