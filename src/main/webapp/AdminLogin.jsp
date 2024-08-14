<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 49px;background-color: rgb(224, 218, 218);">
    <div class="container">
        <h2 align="center" class="display-4"><b>Admin Login</b></h2>
        <hr>
        <img src="adminLogin.gif" width="500px" align="right">
        <br><br>
        <form action="AdminCheck" method="post">
            <table>
                <tr>
                    <th>UserID</th>
                    <td><input type="text" name="uid" style="background-color: rgb(238, 251, 252);" autocomplete="off" required class="form-control"></td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td><input type="password" name="psw" style="background-color: rgb(238, 251, 252);" autocomplete="off" required class="form-control"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit" class="btn btn-outline-primary"></td>
                    <td></td>
                </tr>
            </table>
        </form>

    </div>


</body>
</html>