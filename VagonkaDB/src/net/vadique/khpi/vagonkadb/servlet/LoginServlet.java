package net.vadique.khpi.vagonkadb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.vadique.khpi.vagonkadb.beans.UserAccount;
import net.vadique.khpi.vagonkadb.utils.MyUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		if(username.equals("vagonka_manager") || username.equals("vagonka_admin"))
		{
			if (username.equals("vagonka_manager") && password.equals("barohka057"))
			{
				UserAccount user = new UserAccount(username, password);
				MyUtils.storeLoginedUser(session, user);
				dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
			}
			else if (username.equals("vagonka_admin") && password.equals("321nimda"))
			{
				UserAccount user = new UserAccount(username, password);
				MyUtils.storeLoginedUser(session, user);
				dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
			}
			else {
				dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/errorlogin.jsp");
			}
		}
		else {
				dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/nouser.jsp");
		}
		dispatcher.forward(request, response);
	}

}
