<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Information</title>
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"></link>
</head>
<body>
	<h1>Name: ${student.getName() }</h1>
	<h1>Id: ${student.getId() }</h1>
	<h1>date: ${student.getDate() }</h1>
	<h1>Subjects: ${student.getSubjects() }</h1>
	<h1>Gender: ${student.getGender() }</h1>
	<h1>Type: ${student.getType() }</h1>
</body>
</html>