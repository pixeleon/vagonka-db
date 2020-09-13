package net.pixeleon.khpi.vagonkadb.servlet;

import net.pixeleon.khpi.vagonkadb.beans.SizedProduct;
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
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        int spId = Integer.parseInt(request.getParameter("id"));
        try {
            SizedProduct sizedProduct = DBUtils.findSizedProduct(conn, spId);
            request.setAttribute("product", sizedProduct);
            getServletContext().getRequestDispatcher("/WEB-INF/views/editsizedproduct.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        int spId = Integer.parseInt(request.getParameter("id"));
        double lengthFrom = Double.parseDouble(request.getParameter("lfrom"));
        double lengthTo = Double.parseDouble(request.getParameter("lto"));
        double width = Double.parseDouble(request.getParameter("w"));
        double thickness = Double.parseDouble(request.getParameter("th"));
        try {
            DBUtils.updateSizedProduct(conn, spId, lengthFrom, lengthTo, width, thickness);
            response.sendRedirect(request.getContextPath() + "/sizes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
