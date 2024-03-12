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
	<ul>
		<li>자바에서 if 문과 비슷한 기능을 제공한다.</li>
		<li>c:if test="조건" var="변수명"</li>
		<li>var 안에는 test 안의 조건 결과(true|false) 를 지정된 변수에 저장 할 수 있다.</li>
		<li>c:if 에는 else 가 없다.</li>
	</ul>
	
	<% if(true){ %>
 			항상 실행 된다. <br/>
	<%}%>
	
	<c:if test="true">
		항상 실행 된다. <br/>
	</c:if>
	
	<c:set var="myId">admin2</c:set>
	<!-- c태그에서는 equals로 문자열을 비교 안해도 된다. == 혹은 eq -->
	<c:if test="${myId == 'admin'}"> 
		myId 는 admin 이 맞습니다.<br/>
	</c:if>
	<c:if test="${myId != 'admin'}"> 
		myId 는 admin 이 아닙니다.<br/>
	</c:if>
	
</body>
</html>