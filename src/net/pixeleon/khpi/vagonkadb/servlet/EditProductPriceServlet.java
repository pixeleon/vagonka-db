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
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Servlet implementation class EditProductPriceServlet
 */
@WebServlet("/editProductPrice")
public class EditProductPriceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditProductPriceServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        int sizedProductId = Integer.parseInt(request.getParameter("id"));
        SizedProductPrice productPrice = null;
        try {
            productPrice = DBUtils.findProductPrice(conn, sizedProductId);
            request.setAttribute("price", productPrice);
            getServletContext().getRequestDispatcher("/WEB-INF/views/editproductprice.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String sizedProductId = request.getParameter("id");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        try {
            DBUtils.updateProductPrice(conn, sizedProductId, price, amount);
            getServletContext().getRequestDispatcher("/managerprices").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
