<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" href="resources/css/common.css" type="text/css"/>
<style>
</style>
</head>
<body>
	<h3>글쓰기</h3>
	<hr/>
	<form action="write.do" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject"/></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="user_name"/></td> <!--나중에 자동으로 작성자 들어가게-->
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<th>사진</th>
				<td><input type="file" name="photos" multiple="multiple"/></td>
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