package net.pixeleon.khpi.vagonkadb.servlet;

import net.pixeleon.khpi.vagonkadb.beans.Order;
import net.pixeleon.khpi.vagonkadb.utils.DBUtils;
import net.pixeleon.khpi.vagonkadb.utils.MyUtils;
import net.pixeleon.khpi.vagonkadb.utils.ReportUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
        try {
            List<Order> ordersList = DBUtils.selectOrders(MyUtils.getStoredConnection(request));
            ReportUtils.generateReport(ordersList);
            getServletContext().getRequestDispatcher("/orders").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
