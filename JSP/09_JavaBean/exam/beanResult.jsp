<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="firstBean" class="com.beans.FirstBean" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	출력 방식 1 : <%=firstBean.getName() %>
	<br/>
	출력 방식 2 : <jsp:getProperty name="firstBean" property="name"/>
</body>
</html>