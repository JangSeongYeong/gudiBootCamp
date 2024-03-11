<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션은 서버에 접속하면 그냥 주어지는 객체이다.
	System.out.println("session ID :"+session.getId());
	// 서버를 떠나거나 인위적으로 지울때까지 유지된다. (서버가 꺼졌다가 켜지거나, 브라우저를 종료했을때)
	// 또는 기본 30분이나 지정된 시간동안 아무런 동작을 하지 않으면 초기화 된다.
	// session.setMaxInactiveInterval(10); // 10초간 동작이 없으면 세션 초기화
	System.out.println(session.getMaxInactiveInterval()+"초"); // 기본 30분
	// 은행(네이버) 로그인을 생각 하자
	
	// 세션에 저장된 값 확인
	String name =(String)session.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>세션 테스트</h2>
	<a href="sessionSet.jsp">세션에 값 저장</a><br/>
	<p>세션에 저장된 name 값 : <%=name %></p>
	<a href="sessionDel.jsp">세션에 값 삭제</a><br/>
	<a href="sessionInit.jsp">세션 초기화</a>
	
	
	<h2>세션 예시</h2>
	<a href="example/login.jsp">로그인</a>
</body>
</html>