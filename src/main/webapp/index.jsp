<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OnlineBanking</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top:40px;background-color:rgb(234, 250, 246);">

<%
Calendar cal=Calendar.getInstance();
String dt=cal.getTime().toLocaleString();
%>



    <div class="container">
        <h1 class="display-4" style="color:darkviolet"><b>Online Banking Application</b></h1>
        
        <hr>

        <table class="table">
            <td><img src="nb1.gif" width="700px"></td>
            <td>
            <br><br>
            <form action="Login" method="post">
                <table>
                    <tr>
                        <th>UserID</th>
                        <td><input type="text" name="uid" autocomplete="off" required class="form-control"></td>
                    </tr>
                    <tr>
                        <th>Password</th>
                        <td><input type="password" name="psw" autocomplete="off" required class="form-control">
                        <input type="hidden" name="logdtm" value="<%=dt%>"> 
                        </td>
                    </tr>
                    <tr>
                        <td align="center"><input type="submit" value="Submit" class="btn btn-outline-primary"></td>
                        <td></td>
                    </tr>
                </table>
            </form>
            <br>
                
                <a href="NewUser.html"><img src="images/re.jpeg" alt="New User? Register Now." height="55px"></a>
                <br>
                <a href="AdminLogin.jsp"><img src="images/admin.jpeg" alt="Admin Login" height="150px"></a>
                
            </td>
        </table>

<span>
Developed by Sanjivani
<br>
Spider&copy;2023
</span>
    </div>

</body>
</html>