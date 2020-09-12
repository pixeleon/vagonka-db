package net.pixeleon.khpi.vagonkadb.servlet;

import net.pixeleon.khpi.vagonkadb.beans.CustomerPrice;
import net.pixeleon.khpi.vagonkadb.utils.DBUtils;
import net.pixeleon.khpi.vagonkadb.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class CustomerPricesServlet
 */
@WebServlet("/customerprices")
public class CustomerPricesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CustomerPricesServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerPrice> customerPricesList = DBUtils.selectCustomerPrices(MyUtils.getStoredConnection(request));
        request.setAttribute("customerPricesList", customerPricesList);
        getServletContext().getRequestDispatcher("/WEB-INF/views/customerprices.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
