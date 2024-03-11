<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>application 영역에 저장된 정보</h2>
	<p>id : <%=application.getAttribute("id") %></p>
	<p>name : <%=application.getAttribute("name") %></p>
	<h2>session 영역에 저장된 정보</h2>
	<p>email : <%=session.getAttribute("email") %></p>
	<p>phone : <%=session.getAttribute("phone") %></p>
</body>
</html>