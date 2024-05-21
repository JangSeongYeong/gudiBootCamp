<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>::LOGIN PAGE::</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<!-- static 폴더의 내용을 호출할 때는 그냥 호출해도 된다. *설정 없이 폴더 안에 있으면 됨-->
<!-- application.properties 설정에 의해 특정 요청명일 경우만 static 폴더를 보도록 할 수 있다.-->
<link rel="stylesheet" href="css/common.css" type="text/css">
<style>
</style>
</head>
<body>
	<h2>로그인</h2>

	<form action="login" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id" placeholder="아이디"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="pw" placeholder="패스워드"></td>
			</tr>
			<tr>
				<th colspan="2">
					 <input type="submit" value="로그인"/>
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