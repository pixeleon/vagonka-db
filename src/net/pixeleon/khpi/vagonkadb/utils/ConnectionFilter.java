package net.pixeleon.khpi.vagonkadb.utils;

import net.pixeleon.khpi.vagonkadb.beans.UserAccount;
import net.pixeleon.khpi.vagonkadb.conn.MySQLConnection;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

public class ConnectionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        UserAccount userInSession = MyUtils.getLoginedUser(session);

        Connection conn = null;
        try {
            if (userInSession == null) {
                conn = MySQLConnection.getMySQLConnection();
            } else {
                conn = MySQLConnection.getMySQLConnection(userInSession.getUsername(), userInSession.getPassword());
            }

            conn.setAutoCommit(false);
            MyUtils.storeConnection(request, conn);
            chain.doFilter(request, response);
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
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

}
