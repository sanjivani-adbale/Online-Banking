<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<%@page import="com.sharayu.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>showName</title>
</head>
<body>
<%
int tno=Integer.parseInt(request.getParameter("toacc"));
//out.println("done");

Connection con;
PreparedStatement pst1;
ResultSet rs1;
String nm;

try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	CloudDBConnector dbc=new CloudDBConnector();
	con=dbc.getDbconn();
	//con=DriverManager.getConnection("jdbc:mysql://be3ofgral0h3uhedyadg-mysql.services.clever-cloud.com:3306/be3ofgral0h3uhedyadg?user=ulqyiujwgocf1bcm&password=e9cCEbntdKIl2FxKlo7B");
	
	pst1=con.prepareStatement("select * from accounts where accno=?");
	pst1.setInt(1,tno);
	rs1=pst1.executeQuery();
	if(rs1.next())
	nm=rs1.getString("accnm");
	else
		nm="Not found";
	%>
	Account Name : <span style="color:blue;font-weight:bold"><%=nm %></span>
	<%
	con.close();
}
catch(Exception e)
{
	out.println(e);
}

%>
</body>
</html>