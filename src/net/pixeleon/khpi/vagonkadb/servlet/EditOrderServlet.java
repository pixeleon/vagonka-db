package net.pixeleon.khpi.vagonkadb.servlet;

import com.sun.org.apache.xpath.internal.operations.Or;
import net.pixeleon.khpi.vagonkadb.beans.Order;
import net.pixeleon.khpi.vagonkadb.utils.DBUtils;
import net.pixeleon.khpi.vagonkadb.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Servlet implementation class EditOrderServlet
 */
@WebServlet("/editorder")
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
        try {
            Order order = DBUtils.findOrder(conn, orderId);
            request.setAttribute("order", order);
            getServletContext().getRequestDispatcher("/WEB-INF/views/editorder.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        int orderId = Integer.parseInt(request.getParameter("id"));
        String customerName = request.getParameter("name");
        String customerPhone = request.getParameter("phone");
        String customerEmail = request.getParameter("email");
        String orderInfo = request.getParameter("info");
        Order order = new Order(orderId, customerName, customerPhone, customerEmail, orderInfo, null);
        try {
            DBUtils.updateOrder(conn, order);
            response.sendRedirect(request.getContextPath() + "/orders");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
