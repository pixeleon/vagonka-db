package net.pixeleon.khpi.vagonkadb.servlet;

import net.pixeleon.khpi.vagonkadb.beans.ProductInfo;
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
 * Servlet implementation class ProductInfoServlet
 */
@WebServlet("/products")
public class ProductInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProductInfoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductInfo> productList = DBUtils.selectProducts(MyUtils.getStoredConnection(request));
        request.setAttribute("productList", productList);
        getServletContext().getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
