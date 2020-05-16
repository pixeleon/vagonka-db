package net.vadique.khpi.vagonkadb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vadique.khpi.vagonkadb.beans.ProductSizeInfo;
import net.vadique.khpi.vagonkadb.utils.DBUtils;
import net.vadique.khpi.vagonkadb.utils.MyUtils;

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
		List<ProductSizeInfo> productSizesList = null;
		productSizesList = DBUtils.selectProductSizes(MyUtils.getStoredConnection(request));
		request.setAttribute("productSizesList", productSizesList);
		getServletContext().getRequestDispatcher("/WEB-INF/views/sizes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
