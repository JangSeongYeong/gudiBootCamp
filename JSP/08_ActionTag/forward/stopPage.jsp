<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	/*
	String page_ = request.getParameter("forwardPage");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String address = request.getParameter("address");

	System.out.println(page_+"/"+name+"/"+age+"/"+address);
	
	response.sendRedirect("result.jsp");
	*/
%>
<!--  전송해준 파라메터 + 내가 보내고 싶은 데이터 -->
<jsp:forward page='<%=request.getParameter("forwardPage") %>'>
	<jsp:param name="tel" value="010-2034-3054"/>
</jsp:forward>