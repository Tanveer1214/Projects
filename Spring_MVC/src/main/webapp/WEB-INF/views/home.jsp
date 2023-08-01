<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>This is Starting Home Page...</h1>
	
	<%
		List<String> list = (List<String>) request.getAttribute("names");
	%>
	
	<%
		for(String s : list) {
	%>
	<h1><%= s %></h1>
	
	<%
		}
	%>
</body>
</html>