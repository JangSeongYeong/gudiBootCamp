<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" href="css/common.css" type="text/css">
<style>

</style>
</head>
<body>
	<table>
		<tr>
			<th>글번호</th>
			<td>${bbs.idx}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${bbs.bHit}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${bbs.subject}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${bbs.user_name}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${bbs.content}</td>
		</tr>
		<tr>
			<th colspan="2"><a href="./list">리스트로 돌아가기</a></th>
		</tr>
		<tr>
			<th colspan="2"><button onclick="location.href='./updateForm.go?idx=${bbs.idx}'">수정하기</button></th>
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