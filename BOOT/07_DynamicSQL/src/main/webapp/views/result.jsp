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
	<p>${msg}</p>
	<form action="list.do" method="get">
		<select name="opt">
			<option value="id">아이디</option>
			<option value="name">이름</option>
			<option value="email">이메일</option>
		</select>
		<input type="text" name="keyword" placeholder="검색어를 입력해 주세요"/>
		<button>검색</button>
	</form>
</body>
<script></script>
</html>