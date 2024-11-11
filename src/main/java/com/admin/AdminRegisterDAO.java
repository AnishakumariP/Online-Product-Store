package com.admin;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;

import dbconn.DBConnection;

@SuppressWarnings("serial")
public class AdminRegisterDAO implements Serializable{
	public static int addAdmin(AdminBean ab) {
		int k = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement
			("INSERT INTO ADMINBEAN VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, ab.getUname());
			ps.setString(2, ab.getPass());
			ps.setString(3, ab.getFname());
			ps.setString(4, ab.getLname());
			ps.setString(5, ab.getMail());
			ps.setLong(6, ab.getPhno());
			ps.setString(7, ab.getAddress());
			
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
