<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
	table, th, td{
		border: 1px solid black;
		border-collapse: collapse;
	}
	
	th, td{
		padding: 5px 10px;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<c:if test="${list.size()<1}">
			<tr><td colspan="5">작성된 게시글이 없습니다.</td></tr>
		</c:if>
		<c:forEach items="${list}" var="bbs">
			<tr>
				<td>${bbs.idx}</td>
				<td>${bbs.subject}</td>
				<td>${bbs.user_name}</td>
				<td>${bbs.bHit}</td>
				<td>${bbs.reg_date}</td>
			</tr>
		</c:forEach>
	</table>
</body>
<script></script>
</html>