<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 40px;background-color: rgb(224, 218, 218);">
<div class="container">
<h1 align="center" class="display-4"><b>Logged out!</b></h1>
<hr>
You are successfully logged out.
<br><br>
<%
session.invalidate();
%>
<a href="index.jsp"><img src="images/home.jpg" alt="Home" height="55px"></a>
</div>
</body>
</html>