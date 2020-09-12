package net.pixeleon.khpi.vagonkadb.servlet;

import net.pixeleon.khpi.vagonkadb.beans.SizedProductPrice;
import net.pixeleon.khpi.vagonkadb.utils.DBUtils;
import net.pixeleon.khpi.vagonkadb.utils.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class ManagerPricesServlet
 */
@WebServlet("/managerprices")
public class ManagerPricesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ManagerPricesServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<SizedProductPrice> managerPricesList = DBUtils.selectProductPrices(MyUtils.getStoredConnection(request));
            request.setAttribute("productPricesList", managerPricesList);
            getServletContext().getRequestDispatcher("/WEB-INF/views/managerprices.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
