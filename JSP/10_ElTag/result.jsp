<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String str = "출력할 문장";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Expression Language TAG -->
	<!-- 스크립틀릿의 출력문을 대체 -->
	session 의 내용 출력 : ${sessionScope.sessionId}
	<br/>
	parameter 값 출력 : ${param.userId} 
</body>
</html>