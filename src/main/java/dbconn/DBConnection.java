package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection con;
	
	static {
		try {
			con = DriverManager.getConnection(DBInfo.url, DBInfo.uname, DBInfo.password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private DBConnection() {};
	public static Connection getConnection() {
		return con;
	}

}
