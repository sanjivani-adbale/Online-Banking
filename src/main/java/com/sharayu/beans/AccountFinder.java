package com.sharayu.beans;
import java.sql.*;

public class AccountFinder {
	private int accno;
	private String accnm;
	private String acctype;
	private double balance;
	
	public AccountFinder()
	{
		accno=0;
		accnm="Not Found";
		acctype="Not Found";
		balance=0.0;
	}

	public String getAccnm() {
		return accnm;
	}

	public String getAcctype() {
		return acctype;
	}

	public double getBalance() {
		return balance;
	}

	public void setAccno(int accno) {
		this.accno = accno;
		retrieveData();
	}
	
	private void retrieveData()
	{
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			CloudDBConnector dbc=new CloudDBConnector();
			con=dbc.getDbconn();
			//con=DriverManager.getConnection("jdbc:mysql://be3ofgral0h3uhedyadg-mysql.services.clever-cloud.com:3306/be3ofgral0h3uhedyadg?user=ulqyiujwgocf1bcm&password=e9cCEbntdKIl2FxKlo7B");
			pst=con.prepareStatement("select * from accounts where accno=?");
			pst.setInt(1, accno);
			rs=pst.executeQuery();
			if(rs.next())
			{
				accnm=rs.getString("accnm");
				acctype=rs.getString("acctype");
				balance=rs.getDouble("balance");
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	

}
