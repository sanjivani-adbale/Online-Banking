<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.sql.*" %>
    <%@page import="com.sharayu.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>balance info</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 40px;background-color: rgb(224, 218, 218);">
    <div class="container">
        <h2 align="center" class="display-4"><b>Account Information</b></h2>
        <hr>
<%
String uid=session.getAttribute("userid").toString();
//out.println("User :"+uid);
Connection con;
PreparedStatement pst1;
ResultSet rs1;
int ano=0;
String nm="",typ="";
double bal=0.0;

try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	CloudDBConnector dbc=new CloudDBConnector();
	con=dbc.getDbconn();
	//con=DriverManager.getConnection("jdbc:mysql://be3ofgral0h3uhedyadg-mysql.services.clever-cloud.com:3306/be3ofgral0h3uhedyadg?user=ulqyiujwgocf1bcm&password=e9cCEbntdKIl2FxKlo7B");
	ano=(Integer) session.getAttribute("accno");
	pst1=con.prepareStatement("select * from accounts where accno=?");
	pst1.setInt(1,ano);
	rs1=pst1.executeQuery();
	rs1.next();
	nm=rs1.getString("accnm");
	typ=rs1.getString("acctype");
	bal=rs1.getDouble("balance");
	
	con.close();
}
catch(Exception e)
{
	out.println(e);
}
%>


<table class="table table-bordered" style="width:45%;border-color: rgb(73, 58, 58);">
<tr>
	<td>UserID</td>
	<td><%=uid %></td>
</tr>
<tr>
	<td>Account Number</td>
	<td><%=ano %></td>
</tr>
<tr>
	<td>Name</td>
	<td><%=nm%></td>
</tr>
<tr>
	<td>Type</td>
	<td><%=typ%></td>
</tr>

<tr>
	<td>Balance</td>
	<td style="color:blue;font-size:15px;font-weight:bold"><%=bal%></td>
</tr>

</table>



<br><br>
<a href="Customer.jsp"><img src="images/home.jpg" height="55px"></a>

    </div>

</body>
</html>