<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style></style>
</head>
<body>
	<c:if test="${list.size()>0}">
		<c:forEach items="${list}" var="path">
			<img width="250px" src="photo/${path}"/>
			<a href="download/${path}">다운로드</a>
			<a href="delete?file=${path}">삭제</a>
			<hr/>
		</c:forEach>
	</c:if>
	<c:if test="${list.size()==0}">
		업로드 된 사진이 없습니다.
	</c:if>
	<button onclick="location.href='./'">돌아가기</button>
</body>
<script></script>
</html>