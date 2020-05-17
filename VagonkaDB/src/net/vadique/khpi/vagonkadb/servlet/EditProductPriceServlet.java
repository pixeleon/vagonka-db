package net.vadique.khpi.vagonkadb.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vadique.khpi.vagonkadb.beans.ProductPrice;
import net.vadique.khpi.vagonkadb.utils.DBUtils;
import net.vadique.khpi.vagonkadb.utils.MyUtils;

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
		String sizedProductId = (String) request.getParameter("id");
		ProductPrice productPrice = null;
		productPrice = DBUtils.findProductPrice(conn, sizedProductId);
		
		request.setAttribute("price", productPrice);
		getServletContext().getRequestDispatcher("/WEB-INF/views/editproductprice.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		 
        String sizedProductId = (String) request.getParameter("id");
        double price = Double.parseDouble(request.getParameter("price"));
        DBUtils.updateProductPrice(conn, sizedProductId, price);
        getServletContext().getRequestDispatcher("/managerprices").forward(request, response);
	}

}
