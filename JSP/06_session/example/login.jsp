<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	login.jsp 에서 id 와 pass 를 main.jsp 에 전달
	main.jsp 에서 id 와 pass 가 일치하면 main.jsp 내용을 보여주고
	일치하지 않으면 login.jsp 로 돌려 보낸다.
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td{
		border: 1px solid black;
		border-collapse: collapse;
	}
	td {
		padding: 5px 10px;
		text-align: center;
	}
</style>
</head>
<body>
	<form action="main.jsp" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="login"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>