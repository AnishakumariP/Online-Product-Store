package com.bank63;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbconn.DBConnection;

public class ViewAccountsDAO {
	public static BankBean viewAccounts(long acno, String name){
		BankBean bb = new BankBean();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DBConnection.getConnection();
			
			PreparedStatement ps =con.prepareStatement
			("SELECT * FROM BANK63 WHERE ACCNO=? AND NAME=?");
			ps.setLong(1, acno);
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bb.setAccno(rs.getLong(1));
				bb.setHolderName(rs.getString(2));
				bb.setBal(rs.getDouble(3));
				bb.setActype(rs.getString(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bb;
	}

}
