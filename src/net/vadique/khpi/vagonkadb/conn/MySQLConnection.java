package net.vadique.khpi.vagonkadb.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	public static Connection getMySQLConnection() 
			throws ClassNotFoundException, SQLException {
		
		 String hostName = "localhost";
	     String dbName = "vagonka";
	     String userName = "vagonka_user";
	     String password = "";
	     return getMySQLConnection(userName, password);
	}

	public static Connection getMySQLConnection(String userName, String password) 
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String connectionURL = "jdbc:mysql://localhost/vagonka"
				+ "?noAccessToProcedureBodies=true";
		return DriverManager.getConnection(connectionURL, userName, password);
	}
	
	public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } 
        catch (Exception e) {
        	e.printStackTrace();
        }
    }
 
    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } 
        catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
