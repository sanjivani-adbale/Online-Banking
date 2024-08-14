<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 35px;background-color:rgb(234, 250, 246);">
    <div class="container">
        <h2 align="center" class="display-4"><b>Account Creation</b></h2>
        <hr>
        Status : <%=session.getAttribute("accstatus") %>
        <br>
        <a href="Manager.jsp"><img src="images/home.jpg" alt=""></a>
        </div>
        
</body>
</html>