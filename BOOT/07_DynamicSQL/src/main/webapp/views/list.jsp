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
	
	li {
		list-style-type: none;
	}
</style>
</head>
<body>
	<p>${msg}</p>
	<fieldset>
		<form action="multi.do" method="get">
			이름이
			<ul id="search_name">
				<li>
					<input type="text" name="name"/>
					<input type="button" value="또는" onclick="add(this)" />
				</li>
			</ul>
			인 회원 찾기
			<button>찾기</button>
		</form>
	</fieldset>
	<table>
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>NAME</th>
			<th>AGE</th>
			<th>GENDER</th>
			<th>EMAIL</th>
		</tr>
		<c:forEach items="${list}" var="member">
		<tr>
			<td>${member.id}</td>
			<td>${member.pw}</td>
			<td>${member.name}</td>
			<td>${member.age}</td>
			<td>${member.gender}</td>
			<td>${member.email}</td>
		</tr>
		</c:forEach>
	</table>
	<fieldset>
		<form action="update.do" method="post">
			<p>수정대상 ID : <input type="text" name="id"></p>
			<p>PW : <input type="text" name="pw"></p>
			<p>NAME : <input type="text" name="name"></p>
			<p>AGE : <input type="text" name="age"></p>
			<p>
				GENDER : <input type="radio" name="gender" value="남"> 남
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="gender" value="여"> 여
			</p>
			<p>EMAIL : <input type="text" name="email"></p>
			<button>수정요청</button>
		</form>
	</fieldset>
	
	
	
</body>
<script>
	function add(elem) {
		var content = $(elem).closest('li').html();
		$('#search_name').append('<li>'+content+'</li>');
	}

</script>
</html>