<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		redirect 의 경우 최종 페이지인 result.jsp 를 노출 
		데이터를 이동시킬 수 없다. (페이지 이동만 가능)
	-->
	<p>page : <%=request.getParameter("forwardPage") %></p>
	<p>name : <%=request.getParameter("name") %></p>
	<p>age : <%=request.getParameter("age") %></p>
	<p>address : <%=request.getParameter("address") %></p>
	<p>tel : <%=request.getParameter("tel") %></p>
</body>
</html>