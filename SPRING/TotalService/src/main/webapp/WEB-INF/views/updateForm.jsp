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
	<form action="update.do" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>글번호</th>
				<td><input type="hidden" name="idx" value="${bbs.idx}"/>${bbs.idx}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" value="${bbs.subject}"/></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="user_name" value="${bbs.user_name}"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content">${bbs.content}</textarea></td>
			</tr>
			<tr>
				<th>사진</th>
				<td><input type="file" name="photos" multiple="multiple"/></td> <!-- multiple :  여러파일 추가 가능 -->
			</tr>
			<c:if test="${photos.size()>0}">
				<tr>
					<th>이미지</th>
					<td>
						<c:forEach items="${photos}" var="photo">
							<img src="/photo/${photo.new_filename}"/>
							<!-- 좌에서 우로 가는게 싫다면 줄바꿈을 넣는다. -->
							<br/>					
						</c:forEach>
					</td>
				</tr>
			</c:if>
			<tr>
				<th colspan="2">
					<input type="button" onclick="location.href='./list'" value="리스트">
					<button>확인</button>
				</th>
			</tr>
		</table>
	</form>
</body>
<script>
	var msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}
</script>
</html>