<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.sharayu.beans.FundsTransfer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 40px;background-color: rgb(224, 218, 218);">
    <div class="container">
        <h2 align="center" class="display-4"><b>Money transfer</b></h2>
        <hr>
        <%
		int fromacc,toacc;
        double amount;
        String remarks,status;
        
        fromacc=Integer.parseInt(request.getParameter("fromacc"));
        toacc=Integer.parseInt(request.getParameter("toacc"));
        amount=Double.parseDouble(request.getParameter("amount"));
        remarks=request.getParameter("remarks");
        
        FundsTransfer ft=new FundsTransfer();
        ft.setFromacc(fromacc);
        ft.setToacc(toacc);
        ft.setAmount(amount);
        ft.setRemarks(remarks);
        
        %>
        Status of the transaction : <%=ft.getStatus() %>
        <br>
        <a href="Customer.jsp"><img src="images/home.jpg" height="55px"></a>
        </div>
</body>
</html>