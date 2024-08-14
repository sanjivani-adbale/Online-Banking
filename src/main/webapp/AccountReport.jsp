<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
    <%@page import="com.sharayu.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>account report</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 40px;background-color: rgb(224, 218, 218);">
    <div class="container">
    
    <%
    if(session.getAttribute("userid")!=null && session.getAttribute("usertype").equals("manager"))
    {
    %>
        <h1 align="center" class="display-4"><b>Accounts Report</b></h1>
        <a href="Manager.jsp">Home</a>
        <hr>

        <table class="table table-bordered table-hover">
            <tr style="background-color: rgb(224, 178, 201);">
                <th>Number</th>
                <th>Name</th>
                <th>Type</th>
                <th>Balance</th>
            </tr>
            <%
            Connection con;
            Statement st;
            ResultSet rs;
            
            try
            {
            	Class.forName("com.mysql.cj.jdbc.Driver");
            	CloudDBConnector dbc=new CloudDBConnector();
        		con=dbc.getDbconn();
    			//con=DriverManager.getConnection("jdbc:mysql://be3ofgral0h3uhedyadg-mysql.services.clever-cloud.com:3306/be3ofgral0h3uhedyadg?user=ulqyiujwgocf1bcm&password=e9cCEbntdKIl2FxKlo7B");
    			st=con.createStatement();
    			rs=st.executeQuery("select * from accounts");
    			while(rs.next())
    			{
    				%>
    				<tr>
                		<td><%=rs.getInt("accno") %></td>
                		<td><%=rs.getString("accnm") %></td>
                		<td><%=rs.getString("acctype") %></td>
                		<td><%=rs.getDouble("balance") %></td>
            		</tr>
    				<%
    			}
    			con.close();
            }
            catch(Exception e)
            {
            	out.println(e);
            }
            
            %>
            
            
            
        </table>

<%
    }
    else
    {
    	%>
    	<h2>Invalid session...</h2>
    	<br>
    	Please login to see the information
    	<br>
    	<a href="AdminLogin.jsp"><img src="images/home.jpg" height="55px"></a>
    	<%
    }
%>
    </div>

</body>
</html>