package com.history;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbconn.DBConnection;

public class HistoryProductDAO {
	public static int insert(SoldProductHistoryBean sb) {
		int k = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement
			("INSERT INTO SOLDPRODUCTSHISTORY VALUES(?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, sb.getPcode());
			ps.setString(2, sb.getPname());
			ps.setDouble(3, sb.getPrice());
			ps.setString(4, sb.getCname());
			ps.setString(5, sb.getMail());
			ps.setLong(6, sb.getPhno());
			ps.setString(7, sb.getHolderName());
			ps.setLong(8, sb.getAccno());
			ps.setInt(9, sb.getQty());
			ps.setDouble(10, sb.getTotAmt());
			
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
		
	}

}
