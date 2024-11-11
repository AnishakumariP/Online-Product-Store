package com.history;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbconn.DBConnection;

public class ViewSoldProductHistoryDAO {
	public static ArrayList<SoldProductHistoryBean> viewHistory(){
		ArrayList<SoldProductHistoryBean> list = new ArrayList<SoldProductHistoryBean>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement
			("SELECT * FROM SOLDPRODUCTSHISTORY");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SoldProductHistoryBean sb = new SoldProductHistoryBean();
				sb.setPcode(rs.getString(1));
				sb.setPname(rs.getString(2));
				sb.setPrice(rs.getDouble(3));
				sb.setCname(rs.getString(4));
				sb.setMail(rs.getString(5));
				sb.setPhno(rs.getLong(6));
				sb.setHolderName(rs.getString(7));
				sb.setAccno(rs.getLong(8));
				sb.setQty(rs.getInt(9));
				sb.setTotAmt(rs.getDouble(10));
				
				list.add(sb);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
