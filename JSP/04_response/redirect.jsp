<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	System.out.println("redirect.jsp 들림");
	// response.sendRedirect("goToPage.jsp");
	
	// post 방식으로 전송시 한글이 깨진다.
	// post 방식 전송시 아래 구문을 맨 윗줄에 넣어주자 setCharacterEncoding
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	System.out.println(name);
	
	// 받아온 이름이 '관리자'일 경우 goToPage.jsp 로 이동
	// 그 외는 index.jsp로 이동
	String loc ="index.jsp";
	if(name.equals("관리자")){
		loc = "goToPage.jsp";
	} 
	response.sendRedirect(loc);
%>
