package com.customer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;

import dbconn.DBConnection;

@SuppressWarnings("serial")
public class NewCustomerDAO implements Serializable{
	public static int addCustomer(CustomerBean cb) {
		int k = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement
			("INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, cb.getUname());
			ps.setString(2, cb.getPass());
			ps.setString(3, cb.getFname());
			ps.setString(4, cb.getLname());
			ps.setString(5, cb.getMail());
			ps.setLong(6, cb.getPhno());
			ps.setString(7, cb.getAddress());
			
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
