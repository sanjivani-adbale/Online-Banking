<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 40px;background-color: rgb(224, 218, 218);">
<%
String uid=session.getAttribute("userid").toString();
%>

    <div class="container">
        <h2 align="center" style="color:darkgreen" class="display-4"><b>Account Holder Home</b></h2>
        Logged in as : <b><%=uid %></b> | 
        Account Number : <%=session.getAttribute("accno") %> | 
        Session ID : <%=session.getId() %>
        <br>
        Logged in at : <b><%=session.getAttribute("logtime")%></b>
        <br>
        <img src="images/<%=uid%>.jpg" width="150" class="rounded">
        <hr>
        <a href="FindBalance.jsp">Find Balance</a>
        <br>
        <a href="Transfer.html">Transfer Money</a>
        <br>
        <a href="Summary.jsp">Transaction Summary</a>
        <br>
        <a href="Logout.jsp">Logout</a>

    </div>
</body>
</html>