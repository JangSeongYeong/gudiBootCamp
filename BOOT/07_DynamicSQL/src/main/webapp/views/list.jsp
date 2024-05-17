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
</style>
</head>
<body>
	<p>${msg}</p>
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
	
	
	
	
</body>
<script></script>
</html>