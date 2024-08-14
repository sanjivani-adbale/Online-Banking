package com.sharayu.beans;

import java.sql.*;


public class FundsTransfer {
private int fromacc;
private int toacc;
private double amount;
private String remarks;
private String status;

public FundsTransfer()
{
	fromacc=0;
	toacc=0;
	amount=0.0;
	remarks="";
	status="";
}

public String getStatus() {
	transfer();
	return status;
}

public void setFromacc(int fromacc) {
	this.fromacc = fromacc;
}

public void setToacc(int toacc) {
	this.toacc = toacc;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public void setRemarks(String remarks) {
	this.remarks = remarks;
}

private void transfer()
{
	Connection con;
	PreparedStatement pst;
	
	try
	{
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//con=DriverManager.getConnection("jdbc:mysql://be3ofgral0h3uhedyadg-mysql.services.clever-cloud.com:3306/be3ofgral0h3uhedyadg?user=ulqyiujwgocf1bcm&password=e9cCEbntdKIl2FxKlo7B");
		
		CloudDBConnector dbc=new CloudDBConnector();
		con=dbc.getDbconn();
		
		pst=con.prepareStatement("update accounts set balance=balance-? where accno=?");
		pst.setDouble(1, amount);
		pst.setInt(2, fromacc);
		pst.executeUpdate();
		System.out.println("amount deducted from source account");
		
		pst=con.prepareStatement("update accounts set balance=balance+? where accno=?");
		pst.setDouble(1, amount);
		pst.setInt(2, toacc);
		pst.executeUpdate();
		System.out.println("amount added to destination account");
		
		pst=con.prepareStatement("insert into transferlog(fromacc,toacc,amount,transdt,remark) values(?,?,?,now(),?)");
		pst.setInt(1, fromacc);
		pst.setInt(2, toacc);
		pst.setDouble(3, amount);
		pst.setString(4, remarks);
		pst.executeUpdate();
		System.out.println("transfer log maintained");
		
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
