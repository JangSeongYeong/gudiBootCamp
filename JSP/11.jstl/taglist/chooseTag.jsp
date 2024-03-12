<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
	<h3><%=request.getParameter("num") %></h3>
	${param.num}
	 --%>
	 
	 <ul>
		<li>자바에서 switch 구문과 비슷한 형태이다.(조건문 사용 가능)</li>
	 	<li>c:when 태그에 조건을 넣어서 실행하도록 한다.(if)</li>
	 	<li>c:otherwise 로 어떠한 조건에도 해당되지 않는 내용을 실행 한다.(else)</li>
	 </ul>
	 <!-- 파라메터의 값에 따른 메시지 출력 -->
	 <c:choose>
	 	<c:when test="${param.num eq '0'}">파라메터 값은 0 입니다.</c:when>
	 	<c:when test="${param.num eq '1'}">파라메터 값은 1 입니다.</c:when>
	 	<c:when test="${param.num eq '2'}">파라메터 값은 2 입니다.</c:when>
	 	<c:otherwise>파라메터 값은 0~2 사이에 있어야 합니다.</c:otherwise>
	 </c:choose>
	 
</body>
</html>