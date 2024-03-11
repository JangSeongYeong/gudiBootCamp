<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% session.setAttribute("sessionId", session.getId()); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="result.jsp">
		ID : <input type="text" name="userId"/>
		<button>전송</button>
	</form>
	<a href="operator.jsp">연산자 예제</a>
</body>
</html>