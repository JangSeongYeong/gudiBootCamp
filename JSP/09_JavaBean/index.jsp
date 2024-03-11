<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 빈(데이터를 담고 있는 자바 파일) 등록 -->
<!-- id : 호출 시 이름, class : 사용할 빈의 위치와 클래스, scope : 사용 영역(page, request, session, application -->
<jsp:useBean id="firstBean" class="com.beans.FirstBean" scope="page"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 자바 파일이 변경될 때는 컴파일 언어이기 때문에 새로 고침이 아닌 서버를 껐다가 켜야 한다. -->
	<h3>name : <%=firstBean.getName() %></h3>
	<a href="exam/form.jsp">bean 사용 예제</a>
</body>
</html>