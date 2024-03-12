<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	session.setAttribute("myId", "admin");
	session.setAttribute("uId", "105784");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  el 태그에서 변수를 표현하고 싶다면 set 태그로 먼저 선언해야 한다. -->
	<%-- <c:set var="변수명" value="값" [scope="영역"]/> --%>
	<%-- <c:set var="변수명" [scope="영역"]>값</c:set> --%>
	<h3>OPTION</h3>
	<ul>
		<li>var : el 태그에서 호출할 이름</li>
		<li>value : 이때 보여줄 값</li>
		<li>scope : 저장 영역(page, request, session, application | 지정안하면 page 기본값)</li>
	</ul>
	<!-- value 속성 -->
	<c:set var="name1" value="test" scope="page"/>
	<c:set var="name2" value="${sessionScope.myId}"/>
	<c:set var="name3" value="${sessionScope.myId}${sessionScope.uId}" scope="request"/>
	<!-- 태그 몸체 -->
	<c:set var="name4">test2</c:set>
	
	${name1}<br/>
	${name2}<br/>
	${name3}<br/>
	${name4}
	
	
	<h3>속성 삭제</h3>
	<%-- <c:remove var="변수명"/> --%>
	<c:remove var="name3"/>
	
	${name1}<br/>
	${name2}<br/>
	${name3}<br/>
	${name4}
	
</body>
</html>