<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<c:if test="${list.size() > 0}">
		<c:forEach items="${list}" var="map">
			<c:if test="${map.image == 'true'}">
				<img width="300px" src="photo/${map.name}"/>
				<a href="delete?file=${map.name}">삭제</a>
			</c:if>
			<c:if test="${map.image == 'false'}">
				<a href="download/${map.name}">${map.name} 다운로드</a>
				<a href="delete?file=${map.name}">삭제</a>
			</c:if>
			<hr>
		</c:forEach>
	</c:if>
	<c:if test="${list.size()==0}">업로드된 사진이 없습니다.</c:if>
	
	<a href="./">돌아가기</a>

</body>
</html>