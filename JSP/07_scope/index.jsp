<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="application.jsp" method="post">
		<table border="1">
			<caption>Application 에 저장될 내용</caption>
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id"/></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" value="전송"/></th>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>