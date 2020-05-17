package net.vadique.khpi.vagonkadb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vadique.khpi.vagonkadb.beans.ProductInfo;
import net.vadique.khpi.vagonkadb.utils.DBUtils;
import net.vadique.khpi.vagonkadb.utils.MyUtils;

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
		List<ProductInfo> productList = null;
		productList = DBUtils.selectProducts(MyUtils.getStoredConnection(request));
	request.setAttribute("productList", productList);
		getServletContext().getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
