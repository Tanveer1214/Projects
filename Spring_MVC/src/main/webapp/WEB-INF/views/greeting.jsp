<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>How are you?</h1>
	
	<%
		String greet = (String) request.getAttribute("greet");
		LocalDateTime localDateTime = (LocalDateTime) request.getAttribute("time");
	%>
	
	<h1><%= greet %></h1>
	<h1>Today Time And Date: <%= localDateTime.toString() %></h1>
	<h1>${greet}</h1>
	
	<h1>
		<hr>
		
		<c:forEach var="i" items = "${g }">
			<h1>${i}</h1>
		</c:forEach>
		
	</h1>
	
</body>
</html>