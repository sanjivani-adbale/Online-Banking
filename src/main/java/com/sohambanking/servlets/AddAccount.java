package com.sohambanking.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.sharayu.beans.AccountCreator;

/**
 * Servlet implementation class AddAccount
 */
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int accno;
		String accnm,acctype;
		double balance;
		
		accno=Integer.parseInt(request.getParameter("accno"));
		accnm=request.getParameter("accnm");
		acctype=request.getParameter("acctype");
		balance=Double.parseDouble(request.getParameter("balance"));
		
		AccountCreator ac=new AccountCreator();
		ac.setAccno(accno);
		ac.setAccnm(accnm);
		ac.setAcctype(acctype);
		ac.setBalance(balance);
		String stat=ac.getStatus();
		
		HttpSession ses=request.getSession(true);
		ses.setAttribute("accstatus", stat);
		
		response.sendRedirect("AccountCreation.jsp");

	}

}
