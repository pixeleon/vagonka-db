package net.vadique.khpi.vagonkadb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vadique.khpi.vagonkadb.beans.Order;
import net.vadique.khpi.vagonkadb.utils.DBUtils;
import net.vadique.khpi.vagonkadb.utils.MyUtils;

/**
 * Servlet implementation class MakeOrderServlet
 */
@WebServlet("/makeorder")
public class MakeOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MakeOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/makeorder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerName = request.getParameter("name");
		String customerPhone = request.getParameter("phone");
		String customerEmail = request.getParameter("email");
		String orderInfo =  request.getParameter("info");
		Order order = new Order(customerName, customerPhone, customerEmail, orderInfo);
		DBUtils.insertOrder(MyUtils.getStoredConnection(request), order);
		getServletContext().getRequestDispatcher("/WEB-INF/views/ordersuccess.jsp").forward(request, response);
	}

}
