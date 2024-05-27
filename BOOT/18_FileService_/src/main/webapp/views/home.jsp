<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h4> 단일 파일 업로드 </h4>
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file"/>
		<input type="submit" name="전송"/>
	</form>
	<br/><hr>
	
	<h4> 다중 파일 업로드 </h4>
	<form action="multiUpload" method="post" enctype="multipart/form-data">
		<input type="file" name="files" multiple="multiple"/>
		<input type="submit" name="전송"/>
	</form>
	<br/><hr>
	
	<a href="./list">파일 리스트</a>

</body>
</html>