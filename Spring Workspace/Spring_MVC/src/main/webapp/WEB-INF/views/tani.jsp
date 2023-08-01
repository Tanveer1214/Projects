<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tani page</title>
</head>
<body>
	<%
		String name = (String) request.getAttribute("name");
	%>
	<h1>Hello Iam <%=name%></h1>
</body>
</html>