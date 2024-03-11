<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
	td {
		padding: 5px 10px;
	}
</style>
</head>
<body>
	<h3>회원정보</h3>
	<form action="jsUse.jsp" method="get">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName"/></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" value="남자"/>남
					<input type="radio" name="gender" value="여자"/>여
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<!-- 체크박스는 여러개의 값이 전송될 수 있다. -->
				<td>
					<input type="checkbox" name="hobby" value="독서"/>독서
					<input type="checkbox" name="hobby" value="게임"/>게임
					<input type="checkbox" name="hobby" value="축구"/>축구
					<input type="checkbox" name="hobby" value="영화"/>영화
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align : center;">
					<input type="submit" value="전송"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>