<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Page</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="css/common.css" type="text/css">
<style>
</style>
</head>
<body>
	<table>
		<tr>
			<th>글번호</th>
			<td>${dto.idx}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${dto.bHit}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.subject}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${dto.user_name}</td>
		</tr>		
		<tr>
			<th>내용</th>
			<td>${dto.content}</td>
		</tr>
		<tr>
			<th colspan="2">
				<button onclick="location.href = './list'">리스트</button>
			</th>
		</tr>
	</table>
</body>
<script>
	var msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}
</script>
</html>