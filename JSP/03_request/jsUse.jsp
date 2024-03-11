<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>이름 : <span id="userName"></span></p>
	<p>성별 : <span id="gender"></span></p>
	<p>취미 : <span id="hobby"></span></p>
</body>
<script>
	// ' '을 안넣어주면 변수 취급되어 들어간다
	var name = '<%=request.getParameter("userName")%>';
	var gender = '<%=request.getParameter("gender")%>';
	var hobby = [];
	
	document.getElementById('userName').innerHTML = name;
	document.getElementById('gender').innerHTML = gender;
	
	<%
		String[] hobbies = request.getParameterValues("hobby");
		for(String hobby:hobbies){
	%>
			hobby.push('<%=hobby%>');
	<%
		}
	%>
	
	document.getElementById('hobby').innerHTML = hobby.join(",");
	
</script>
</html>