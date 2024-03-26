<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/common.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
</style>
</head>
<body>
	게시판 리스트
	<hr/>
	<button>선택 삭제</button>
	<table>
		<tr>
			<th><input type="checkbox" id="all"/></th>
			<th>글번호</th>
			<th>이미지</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td><input type="checkbox" id="del" value="${item.idx}" /></td>
				<td>${item.idx}</td>
				<td>
					<c:if test="${item.img_cnt > 0}"><img class="icon" src="resources/img/image.png"/></c:if>
					<c:if test="${item.img_cnt == 0}"><img class="icon" src="resources/img/no_image.png"/></c:if>
				</td>
				<td>${item.subject}</td>
				<td>${item.user_name}</td>
				<td>${item.bHit}</td>
				<td>${item.reg_date}</td>
			</tr>
		</c:forEach>
	</table>
</body>
<script>
</script>
</html>