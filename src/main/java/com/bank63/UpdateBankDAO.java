package com.bank63;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbconn.DBConnection;

public class UpdateBankDAO {
	public static int update(BankBean bb) {
		int k = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DBConnection.getConnection();
			
			PreparedStatement ps =con.prepareStatement
			("UPDATE BANK63 SET BAL=? WHERE ACCNO=?");
			
			ps.setLong(2, bb.getAccno());
			ps.setDouble(1, bb.getBal());
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	

}
