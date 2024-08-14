package com.sohambanking.servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.sql.*;

import com.sharayu.beans.CloudDBConnector;
/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id,ps,dtm;
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		int ano=0;
		
		id=request.getParameter("uid");
		ps=request.getParameter("psw");
		dtm=request.getParameter("logdtm");
		
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			CloudDBConnector dbc=new CloudDBConnector();
			con=dbc.getDbconn();
			//con=DriverManager.getConnection("jdbc:mysql://be3ofgral0h3uhedyadg-mysql.services.clever-cloud.com:3306/be3ofgral0h3uhedyadg?user=ulqyiujwgocf1bcm&password=e9cCEbntdKIl2FxKlo7B");
			pst=con.prepareStatement("select * from users where userid=? and pswd=? and userstatus='active'");
			pst.setString(1, id);
			pst.setString(2, ps);
			rs=pst.executeQuery();
			if(rs.next())
			{
				//System.out.println("correct");
				ano=rs.getInt("accno");
				HttpSession ses=request.getSession(true);
				ses.setAttribute("userid", id);
				ses.setAttribute("accno", ano);
				ses.setAttribute("usertype", "customer");
				ses.setAttribute("logtime", dtm);
				response.sendRedirect("Customer.jsp");
			}
			else
			{
				System.out.println("wrong");
				response.sendRedirect("AuthFailure.jsp");
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
