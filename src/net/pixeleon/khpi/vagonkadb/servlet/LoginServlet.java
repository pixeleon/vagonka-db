package net.pixeleon.khpi.vagonkadb.servlet;

import net.pixeleon.khpi.vagonkadb.beans.UserAccount;
import net.pixeleon.khpi.vagonkadb.utils.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher dispatcher;
        if (username.equals("vagonka_manager")) {
            if (password.equals("barohka057")) {
                UserAccount user = new UserAccount(username, password);
                HttpSession session = request.getSession();
                MyUtils.storeLoginedUser(session, user);
                dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
            } else {
                dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/errorlogin.jsp");
            }
        } else {
            dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/nouser.jsp");
        }
        dispatcher.forward(request, response);
    }
}
