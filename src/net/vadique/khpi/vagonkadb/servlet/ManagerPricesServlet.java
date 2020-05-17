package net.vadique.khpi.vagonkadb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vadique.khpi.vagonkadb.beans.ProductPrice;
import net.vadique.khpi.vagonkadb.utils.DBUtils;
import net.vadique.khpi.vagonkadb.utils.MyUtils;

/**
 * Servlet implementation class ManagerPricesServlet
 */
@WebServlet("/managerprices")
public class ManagerPricesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerPricesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProductPrice> pricesList = null;
		pricesList = DBUtils.selectProductPrices(MyUtils.getStoredConnection(request));
		request.setAttribute("pricesList", pricesList);
		getServletContext().getRequestDispatcher("/WEB-INF/views/managerprices.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
