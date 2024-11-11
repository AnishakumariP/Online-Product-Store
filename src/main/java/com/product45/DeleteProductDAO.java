package com.product45;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbconn.DBConnection;

public class DeleteProductDAO {
	public static int delete(String code) {
		int k = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement
			("DELETE FROM PRODUCT45 WHERE PCODE=?");
			ps.setString(1, code);
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
