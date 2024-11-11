package com.product45;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;

import dbconn.DBConnection;

@SuppressWarnings("serial")
public class AddProductDAO implements Serializable{
	private AddProductDAO() {};
	public static int addProduct(ProductBean pb) {
		int k = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement
						("INSERT INTO PRODUCT45 VALUES(?,?,?,?)");
			ps.setString(1, pb.getPcode());
			ps.setString(2, pb.getPname());
			ps.setDouble(3, pb.getPrice());
			ps.setInt(4, pb.getQty());
			
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
