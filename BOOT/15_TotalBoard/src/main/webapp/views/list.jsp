<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<fieldset>
		<p>${loginInfo.name}님 반갑니다.&nbsp;&nbsp;&nbsp;<a href="./logout.do">로그아웃</a></p>
		<button onclick="location.href='./writeForm.go'">글쓰기</button>
	</fieldset>
	<br/>
	<table>
 		<tr>
 			<th>글번호</th>
 			<th>제목</th>
 			<th>작성자</th>
 			<th>조회수</th>
 			<th>작성일</th>
 			<th>삭제</th>
 		</tr>
 		<c:forEach items="${list}" var="bbs">
 		<tr>
 			<td>${bbs.idx}</td>
 			<td><a href="detail.go?idx=${bbs.idx}"> ${bbs.subject}</a></td>
 			<td>${bbs.user_name}</td>
 			<td>${bbs.bHit}</td>
 			<td>${bbs.reg_date}</td>
 			<td><a href="delete.do?idx=${bbs.idx}">삭제</a></td>
 		</tr>
 		</c:forEach>
 	</table>

</body>
<script>
	var msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}
</script>
</html>