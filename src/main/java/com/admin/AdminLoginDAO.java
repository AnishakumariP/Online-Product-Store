package com.admin;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbconn.DBConnection;

@SuppressWarnings("serial")
public class AdminLoginDAO implements Serializable{
	public AdminBean adminLogin(String uname, String pss) {
		AdminBean ab = new AdminBean();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement
					("SELECT * FROM ADMINBEAN WHERE UNAME=? AND PASSWORD=?");
			ps.setString(1, uname);
			ps.setString(2, pss);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ab.setUname(rs.getString(1));
				ab.setPass(rs.getString(2));
				ab.setFname(rs.getString(3));
				ab.setLname(rs.getString(4));
				ab.setMail(rs.getString(5));
				ab.setPhno(Long.parseLong(rs.getString(6)));
				ab.setAddress(rs.getString(7));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ab;
	}

}
