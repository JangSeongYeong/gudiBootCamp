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
	<form action="join.do" method="post">
		<p>ID : <input type="text" name="id"/></p>
		<p>PW : <input type="text" name="pw"/></p>
		<p>NAME : <input type="text" name="name"/></p>
		<p>AGE : <input type="text" name="age"/></p>
		<p>GENDER : 
			<input type="radio" name="gender" value="남"/> 남
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="gender" value="여"/> 여
		</p>
		<p>EMAIL : <input type="text" name="email"/></p>
		<p><button>회원가입</button></p>
	</form>
</body>
<script></script>
</html>