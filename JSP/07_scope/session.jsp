<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String email = request.getParameter("email");
	String phone= request.getParameter("phone");
	System.out.println(email+"/"+phone);
	
	if(email != null && phone != null){
		session.setAttribute("email", email);
		session.setAttribute("phone", phone);		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="result.jsp">저장 내용 확인 하기</a>
</body>
</html>