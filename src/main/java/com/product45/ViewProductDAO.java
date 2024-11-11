package com.product45;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbconn.DBConnection;

@SuppressWarnings("serial")
public class ViewProductDAO implements Serializable{
	public static List<ProductBean> viewProducts(){
		ProductBean pb = null;
		List<ProductBean> pbean = new ArrayList();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM PRODUCT45");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				pb = new ProductBean();
				pb.setPcode(rs.getString(1));
				pb.setPname(rs.getString(2));
				pb.setPrice(rs.getDouble(3));
				pb.setQty(rs.getInt(4));
				
				pbean.add(pb);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pbean;
	}

}
