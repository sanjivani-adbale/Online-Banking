package com.sohambanking.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.*;

import com.sharayu.beans.CloudDBConnector;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id,ps,nm,br,mo;
		int no;
		
		Connection con;
		PreparedStatement pst;
		
		try
		{
		id=request.getParameter("uid");
		ps=request.getParameter("psw");
		nm=request.getParameter("unm");
		no=Integer.parseInt(request.getParameter("ano"));
		br=request.getParameter("brn");
		mo=request.getParameter("mob");
		
		//System.out.println(id+"  "+ps+"  "+nm+"  "+no+"  "+br+" "+mo);
		Class.forName("com.mysql.cj.jdbc.Driver");
		CloudDBConnector dbc=new CloudDBConnector();
		con=dbc.getDbconn();
		//con=DriverManager.getConnection("jdbc:mysql://be3ofgral0h3uhedyadg-mysql.services.clever-cloud.com:3306/be3ofgral0h3uhedyadg?user=ulqyiujwgocf1bcm&password=e9cCEbntdKIl2FxKlo7B");
		pst=con.prepareStatement("insert into users values(?,?,?,default,default,?,?,?)");
		pst.setString(1, id);
		pst.setString(2, ps);
		pst.setString(3, nm);
		pst.setInt(4, no);
		pst.setString(5, br);
		pst.setString(6, mo);
		pst.executeUpdate();
		con.close();
		System.out.println("user registered successfully");
		response.sendRedirect("RegSuccess.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e);
			response.sendRedirect("RegFailed.jsp");
		}
		
	}

}
