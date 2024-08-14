package com.sohambanking.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;

import com.sharayu.beans.CloudDBConnector;

/**
 * Servlet implementation class AdminCheck
 */
public class AdminCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		String id,ps;
		
		id=request.getParameter("uid");
		ps=request.getParameter("psw");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			CloudDBConnector dbc=new CloudDBConnector();
			con=dbc.getDbconn();
			pst=con.prepareStatement("select * from adminusers where userid=? and pswd=? and userstatus='active'");
			pst.setString(1, id);
			pst.setString(2, ps);
			rs=pst.executeQuery();
			if(rs.next())
			{
				String typ=rs.getString("usertype").toString();
				HttpSession ses=request.getSession(true);
				ses.setAttribute("userid", id);
				ses.setAttribute("usertype", typ);
				
				if(rs.getString("usertype").equals("manager"))
					response.sendRedirect("Manager.jsp");
				
				if(rs.getString("usertype").equals("cashier"))
					response.sendRedirect("Cashier.jsp");
					
			}
			else
				response.sendRedirect("AdminFailed.jsp");
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
