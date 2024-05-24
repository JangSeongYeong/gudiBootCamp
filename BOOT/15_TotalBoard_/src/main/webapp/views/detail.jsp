<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/detail.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<style>
	h3 {
		margin: 10px 0;
	}
	table, th, td {
		text-align: center;
		padding: 5px 10px;
		
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
</head>

<body>
	<div class="top-div"></div>

	<div class="subject-div">
		<h3>${item.subject}</h3>
	</div>

	<div class="button-div">
		<div class="button-left-div">
			<button style="margin: 5px" onclick="backList()">뒤로가기</button>
		</div>
		<div class="button-right-div">
			<button style="margin: 5px" onclick="updateGo()">수정</button>
			<button style="margin: 5px" onclick="deleteGo()">삭제</button>
		</div>
	</div>

	<div class="table-div">
		<table>
			<tr>
				<th>글번호</th>
				<td class="bbs_idx">${item.idx}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${item.user_name}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${item.bHit}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>${item.reg_date}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<%-- <c:forEach items="${photos}" var="photo">
						<img src="/photo/${photo.new_filename}" name="bbsphoto"/>
						<br />
					</c:forEach> --%> 
				<br/>${item.content}</td>
			</tr>
		</table>
	</div>
</body>

<script>
	function backList() {
		window.location.href='<c:url value="list.go"/>';
	}
	function updateGo() {
		var idx = $('.bbs_idx').text();
		window.location.href = '<c:url value="update.go?idx='+idx+'"/>';
	}
	function deleteGo() {
		var idx = $('.bbs_idx').text();
		window.location.href = '<c:url value="delete.do?idx='+idx+'"/>';
	}
</script>

</html>