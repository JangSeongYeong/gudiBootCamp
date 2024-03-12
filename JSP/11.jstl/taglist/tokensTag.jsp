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
	<p>java Tokenizer 기능과 같다.</p>
	<p>c:forTokens var="변수명" items="문자열" delims="구분자"</p>
	<p>items="문자열"을 delims="구분자"로 잘라서 var="변수명" 에 저장</p>
	
	<c:set var="text">축구,야구,농구,배구,골프,수영</c:set>
	<c:forTokens items="${text}" delims="," var="sports">
		${sports}<br/>
	</c:forTokens>
	
</body>
</html>