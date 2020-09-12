package net.pixeleon.khpi.vagonkadb.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String userName = "zue12pxc9143ue33";
    private static final String password = "e1zn6qn8z5zd612l";
    private static final String hostName = "eporqep6b4b8ql12.chr7pe7iynqr.eu-west-1.rds.amazonaws.com";
    private static final String port = "3306";
    private static final String dbName = "l0ojmu0la4w8ro5b";

    public static Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException {

//		 String hostName = "localhost";
//	     String dbName = "vagonka";
//	     String userName = "vagonka_user";
//	     String password = "";
        String userName = MySQLConnection.userName;
        String password = MySQLConnection.password;
        return getMySQLConnection(userName, password);
    }

    public static Connection getMySQLConnection(String userName, String password)
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
//		String connectionURL = "jdbc:mysql://"
//				+ "localhost"
//				+ "/vagonka"
//				+ "?noAccessToProcedureBodies=true";
        String connectionURL = "jdbc:mysql://"
                + userName + ":" + password + "@" + hostName + ":" + port + "/" + dbName
                + "?&sslmode=require&noAccessToProcedureBodies=true";
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
