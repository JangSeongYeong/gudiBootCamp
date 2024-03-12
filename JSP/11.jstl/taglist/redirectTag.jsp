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
		<!-- 주소가 url로 바뀐다. -->
		<p>redirect 를 시켜주는 기능</p>
		<p>redirect 태그가 실행되면 이후 태그는 실행되지 않는다.(고로 태그를 넣지 말자)</p>
		<!-- https://www.youtube.com/results?search_query=jsp --> <!-- param을 안넣고 url에 전부 넣어도 상관없음 -->
		<c:redirect url="https://www.youtube.com/results">
			<c:param name="search_query">jsp</c:param>
		</c:redirect>
</body>
</html>