<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 변수 및 메서드 선언문 -->
	<%!
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY); // HOUR 12, HOUR_OF_DAY 24
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);	
	%>
	
	<!-- 출력문 -->
	현재 시간은 <%=hour%>시 <%=min%>분 <%=sec%>초 
	<%if(hour>=12){%>
			오후 입니다.
	<%}else{ %>
			오전 입니다.	
	<%}%>
</body>
</html>