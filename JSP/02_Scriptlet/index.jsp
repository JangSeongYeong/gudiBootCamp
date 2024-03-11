<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<%@ include file="header.jsp" %>
	<h3>여기는 메인 영역 입니다.</h3>
	<ul>
		<%for(int i = 0; i<10; i++){%>
		<li><%= i %></li>
		<%} %>
	</ul>
	<%@ include file="footer.jsp" %>	
</body>
</html>