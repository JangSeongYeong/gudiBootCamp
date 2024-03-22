<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" href="resources/common.css" type="text/css"/>
<style>
</style>
</head>
<body>
	<!-- 사진을 보내기 위한 필수 조건 -->
	<!-- POST 방식으로 보낼 것, form-data 가 여러 파트로 구성되어 있다고 알릴 것 (enctype) -->
	<form action="write" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject"/></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="user_name" value="${sessionScope.loginId}"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<th>사진</th>
				<td><input type="file" name="photos" multiple="multiple"/></td> <!-- multiple :  여러파일 추가 가능 -->
			</tr>
			<tr>
				<th colspan="2">
					<input type="button" onclick="location.href='./list'" value="리스트">
					<button>작성</button>
				</th>
			</tr>
		</table>
	</form>
</body>
<script>
</script>
</html>