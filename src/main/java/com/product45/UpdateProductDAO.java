package com.product45;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbconn.DBConnection;

public class UpdateProductDAO {
	public int k =0;
	public int update(ProductBean pb) {
		try {
			System.out.println(pb);
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement
			("UPDATE PRODUCT45 SET PPRICE=?, PQTY=? WHERE PCODE=?");
			
		ps.setDouble(1, pb.getPrice());
		ps.setInt(2, pb.getQty());
		ps.setString(3, pb.getPcode());
		k = ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
