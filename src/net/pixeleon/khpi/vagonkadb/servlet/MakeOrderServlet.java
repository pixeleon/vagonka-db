package net.pixeleon.khpi.vagonkadb.servlet;

import net.pixeleon.khpi.vagonkadb.beans.Order;
import net.pixeleon.khpi.vagonkadb.utils.DBUtils;
import net.pixeleon.khpi.vagonkadb.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String orderInfo = request.getParameter("info");
        Order order = new Order(customerName, customerPhone, customerEmail, orderInfo);
        DBUtils.insertOrder(MyUtils.getStoredConnection(request), order);
        getServletContext().getRequestDispatcher("/WEB-INF/views/ordersuccess.jsp").forward(request, response);
    }

}
