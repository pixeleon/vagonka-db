package net.vadique.khpi.vagonkadb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vadique.khpi.vagonkadb.beans.Order;
import net.vadique.khpi.vagonkadb.utils.DBUtils;
import net.vadique.khpi.vagonkadb.utils.MyUtils;
import net.vadique.khpi.vagonkadb.utils.ReportUtils;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/report")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Order> ordersList = DBUtils.selectOrders(MyUtils.getStoredConnection(request));
			ReportUtils.generateReport(ordersList);
			getServletContext().getRequestDispatcher("/orders").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
