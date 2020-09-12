package net.pixeleon.khpi.vagonkadb.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String USER_NAME = "zue12pxc9143ue33";
    private static final String PASSWORD = "e1zn6qn8z5zd612l";
    private static final String CONNECTION_STRING = "mysql://zue12pxc9143ue33:e1zn6qn8z5zd612l@eporqep6b4b8ql12.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/l0ojmu0la4w8ro5b";

    public static Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException {

//		 String hostName = "localhost";
//	     String dbName = "vagonka";
//	     String userName = "vagonka_user";
//	     String password = "";
        String userName = USER_NAME;
        String password = PASSWORD;
        return getMySQLConnection(userName, password);
    }

    public static Connection getMySQLConnection(String userName, String password)
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
//		String connectionURL = "jdbc:mysql://"
//				+ "localhost"
//				+ "/vagonka"
//				+ "?noAccessToProcedureBodies=true";
        String connectionURL = "jdbc:" + CONNECTION_STRING;
        return DriverManager.getConnection(connectionURL, userName, password);
    }

    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
