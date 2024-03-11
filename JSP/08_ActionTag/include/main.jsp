<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 태그가 완전히 종결된 이후나 아예 처음에 주석 넣을 것 -->
	<jsp:include page="header.jsp"/>

		<!-- 파라메터 추가 - 특정 값 전달-->
	<jsp:include page="body.jsp">
		<jsp:param name="name" value="my content"/>
	</jsp:include>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>