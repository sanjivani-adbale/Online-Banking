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
    if(session.getAttribute("userid")!=null && session.getAttribute("usertype").equals("customer"))
    {
    	int no=Integer.parseInt(session.getAttribute("accno").toString());
    %>
        <h1 class="display-4">Transaction summary of <%=no %></h1>
        <a href="Customer.jsp"><img src="images/home.jpg" alt="home" height="45px"></a>
        <hr>        

        <table class="table table-bordered table-hover">
            <tr style="background-color: rgb(224, 178, 201);">
                <th>From account</th>
                <th>To account</th>
                <th>Date</th>
                <th>Amount</th>
                <th>Details</th>
            </tr>
            <%
            Connection con;
            PreparedStatement pst;
            ResultSet rs;
            
            try
            {
            	Class.forName("com.mysql.cj.jdbc.Driver");
            	CloudDBConnector dbc=new CloudDBConnector();
        		con=dbc.getDbconn();
    			//con=DriverManager.getConnection("jdbc:mysql://be3ofgral0h3uhedyadg-mysql.services.clever-cloud.com:3306/be3ofgral0h3uhedyadg?user=ulqyiujwgocf1bcm&password=e9cCEbntdKIl2FxKlo7B");
    			pst=con.prepareStatement("select * from transferlog where fromacc=? or toacc=?");
    			pst.setInt(1,no);
    			pst.setInt(2,no);
    			rs=pst.executeQuery();
    			while(rs.next())
    			{
    				%>
    				<tr>
                		<td><%=rs.getInt("fromacc") %></td>
                		<td><%=rs.getString("toacc") %></td>
                		<td><%=rs.getString("transdt") %></td>
                		<td><%=rs.getDouble("amount") %></td>
                		<td><%=rs.getString("remark") %></td>
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
    	<%
    }
%>
    </div>

</body>
</html>