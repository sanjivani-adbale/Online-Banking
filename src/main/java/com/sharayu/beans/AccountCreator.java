package com.sharayu.beans;
import java.sql.*;

public class AccountCreator {
	private int accno;
	private String accnm;
	private String acctype;
	private double balance;
	private String status;
	
	public AccountCreator()
	{
		accno=0;
		accnm="";
		acctype="";
		balance=0.0;
		status="";
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public void setAccnm(String accnm) {
		this.accnm = accnm;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		insertData();
		return status;
	}
	
	private void insertData() {
		Connection con;
		PreparedStatement pst;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			CloudDBConnector dbc=new CloudDBConnector();
			con=dbc.getDbconn();
			//con=DriverManager.getConnection("jdbc:mysql://be3ofgral0h3uhedyadg-mysql.services.clever-cloud.com:3306/be3ofgral0h3uhedyadg?user=ulqyiujwgocf1bcm&password=e9cCEbntdKIl2FxKlo7B");
			pst=con.prepareStatement("insert into accounts values(?,?,?,?)");
			pst.setInt(1, accno);
			pst.setString(2, accnm);
			pst.setString(3, acctype);
			pst.setDouble(4, balance);
			pst.executeUpdate();
			status="success";
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			status="error";
		}
	}

}
