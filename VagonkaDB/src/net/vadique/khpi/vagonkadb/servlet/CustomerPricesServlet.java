package net.vadique.khpi.vagonkadb.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vadique.khpi.vagonkadb.beans.ProductPriceInfo;
import net.vadique.khpi.vagonkadb.utils.DBUtils;
import net.vadique.khpi.vagonkadb.utils.MyUtils;

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
		List<ProductPriceInfo> productPricesList = null;
		productPricesList = DBUtils.select(MyUtils.getStoredConnection(request));
		request.setAttribute("productPricesList", productPricesList);
		getServletContext().getRequestDispatcher("/WEB-INF/views/customerprices.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
