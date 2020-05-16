package net.vadique.khpi.vagonkadb.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vadique.khpi.vagonkadb.beans.Order;
import net.vadique.khpi.vagonkadb.utils.DBUtils;
import net.vadique.khpi.vagonkadb.utils.MyUtils;

/**
 * Servlet implementation class EditOrderServlet
 */
@WebServlet("/editOrder")
public class EditOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrderServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		int orderId = Integer.parseInt(request.getParameter("id"));
		Order order = null;
		order = DBUtils.findOrder(conn, orderId);
		request.setAttribute("order", order);
		getServletContext().getRequestDispatcher("/WEB-INF/views/editorder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		int orderId = Integer.parseInt(request.getParameter("id"));
		String customerName = request.getParameter("name");
		String customerPhone = request.getParameter("phone");
		String customerEmail = request.getParameter("email");
		String orderInfo =  request.getParameter("info");
        Order order = new Order(orderId,customerName, customerPhone, customerEmail, orderInfo, null);
        DBUtils.updateOrder(conn, order);
        response.sendRedirect(request.getContextPath() + "/orders");
	}

}
