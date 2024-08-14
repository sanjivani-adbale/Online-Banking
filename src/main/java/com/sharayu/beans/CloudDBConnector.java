package com.sharayu.beans;

import java.sql.Connection;
import java.sql.DriverManager;

public class CloudDBConnector {
	
	private Connection dbconn;
	
	public CloudDBConnector()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbconn=DriverManager.getConnection("jdbc:mysql://bh4vix549bhvuixiyd00-mysql.services.clever-cloud.com:3306/bh4vix549bhvuixiyd00?user=uscz259ku5qbx86z&password=RDlDXu5m872x8mn9jRNb");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Connection getDbconn() {
		return dbconn;
	}
	
	

}
