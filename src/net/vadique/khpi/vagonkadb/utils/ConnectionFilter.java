package net.vadique.khpi.vagonkadb.utils;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.vadique.khpi.vagonkadb.beans.UserAccount;
import net.vadique.khpi.vagonkadb.conn.MySQLConnection;

public class ConnectionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        UserAccount userInSession = MyUtils.getLoginedUser(session);
       
        
		Connection conn = null;
        try {
            // Create a Connection.
        	if (userInSession == null) {
        		conn = MySQLConnection.getMySQLConnection();
        	}
        	else {
        		conn = MySQLConnection.getMySQLConnection(userInSession.getUsername(), userInSession.getPassword());
        	}
            // Set auto commit to false.
            conn.setAutoCommit(false);

            // Store Connection object in attribute of request.
            MyUtils.storeConnection(request, conn);

            // Allow request to go forward
            // (Go to the next filter or target)
            chain.doFilter(request, response);

            // Invoke the commit() method to complete the transaction with the DB.
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MySQLConnection.rollbackQuietly(conn);
            throw new ServletException();
        } finally {
        	MySQLConnection.closeQuietly(conn);
        }
    }

	@Override
	public void destroy() {
		Filter.super.destroy();
	}

}

