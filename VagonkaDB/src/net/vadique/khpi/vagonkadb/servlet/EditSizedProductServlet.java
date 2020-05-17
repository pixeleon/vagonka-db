package net.vadique.khpi.vagonkadb.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.vadique.khpi.vagonkadb.beans.Order;
import net.vadique.khpi.vagonkadb.beans.ProductSizeInfo;
import net.vadique.khpi.vagonkadb.utils.DBUtils;
import net.vadique.khpi.vagonkadb.utils.MyUtils;

/**
 * Servlet implementation class EditSizedProductServlet
 */
@WebServlet("/editSizedProduct")
public class EditSizedProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSizedProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		String spId = request.getParameter("id");
		ProductSizeInfo sizedProduct = null;
		sizedProduct = DBUtils.findSizedProduct(conn, spId);
		request.setAttribute("product", sizedProduct);
		getServletContext().getRequestDispatcher("/WEB-INF/views/editsizedproduct.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);
		String spId = request.getParameter("id");
		double lengthFrom= Double.parseDouble(request.getParameter("lfrom"));
		double lengthTo = Double.parseDouble(request.getParameter("lto"));
		double width = Double.parseDouble(request.getParameter("w"));
		double thickness =  Double.parseDouble(request.getParameter("th"));
        DBUtils.updateSizedProduct(conn, spId, lengthFrom, lengthTo, width, thickness);
        response.sendRedirect(request.getContextPath() + "/sizes");
	}

}
