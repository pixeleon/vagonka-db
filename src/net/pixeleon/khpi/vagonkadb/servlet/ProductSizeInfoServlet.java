package net.pixeleon.khpi.vagonkadb.servlet;

import net.pixeleon.khpi.vagonkadb.beans.ProductSizeInfo;
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
 * Servlet implementation class ProductSizeInfoServlet
 */
@WebServlet("/sizes")
public class ProductSizeInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProductSizeInfoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductSizeInfo> productSizesList = DBUtils.selectSizedProducts(MyUtils.getStoredConnection(request));
        request.setAttribute("productSizesList", productSizesList);
        getServletContext().getRequestDispatcher("/WEB-INF/views/sizes.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
