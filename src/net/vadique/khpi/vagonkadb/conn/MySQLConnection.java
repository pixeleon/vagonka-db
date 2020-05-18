package net.vadique.khpi.vagonkadb.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	public static Connection getMySQLConnection() 
			throws ClassNotFoundException, SQLException {
		
//		 String hostName = "localhost";
//	     String dbName = "vagonka";
//	     String userName = "vagonka_user";
//	     String password = "";
		String userName = "zue12pxc9143ue33";
		String password = "e1zn6qn8z5zd612l";
	     return getMySQLConnection(userName, password);
	}

	public static Connection getMySQLConnection(String userName, String password) 
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
//		String connectionURL = "jdbc:mysql://"
//				+ "localhost"
//				+ "/vagonka"
//				+ "?noAccessToProcedureBodies=true";
//		Class.forName("org.postgresql.Driver");
//		String connectionURL = "jdbc:postgresql://"
//				+ "ec2-54-75-246-118.eu-west-1.compute.amazonaws.com:5432"
//				+ "/d62hs3sdk2ccl6"
//				+ "?&sslmode=require"
//				+ "&noAccessToProcedureBodies=true";
		String connectionURL = "jdbc:mysql:"
				+ "//zue12pxc9143ue33:e1zn6qn8z5zd612l@eporqep6b4b8ql12.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306"
				+ "/l0ojmu0la4w8ro5b"
				+ "?&sslmode=require"
				+ "&noAccessToProcedureBodies=true";
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
