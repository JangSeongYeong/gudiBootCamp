<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 메서드와 변수 선언 -->
<%!
	String title = "1부터 100까지 합 구하기";

	public int sum(){
		int sum = 0;		
		
		for(int i = 1; i<=100; i++){
			sum += i;
		}
		
		return sum;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<p><%=title %></p>
		<p>답은 <%=sum() %> 입니다.</p>
	</div>
</body>
</html>