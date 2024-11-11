package com.customer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbconn.DBConnection;

@SuppressWarnings("serial")
public class CustomerLoginDAO implements Serializable{
	public static CustomerBean loginCustomer(String uname, String pss) {
		CustomerBean cb = new CustomerBean();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement
					("SELECT * FROM CUSTOMER WHERE UNAME=? AND PASSWORD=?");
			ps.setString(1, uname);
			ps.setString(2, pss);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				cb.setUname(rs.getString(1));
				cb.setPass(rs.getString(2));
				cb.setFname(rs.getString(3));
				cb.setLname(rs.getString(4));
				cb.setMail(rs.getString(5));
				cb.setPhno(Long.parseLong(rs.getString(6)));
				cb.setAddress(rs.getString(7));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cb;
	}


}
