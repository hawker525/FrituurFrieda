package be.vdab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.dao.SausDAO;
import be.vdab.entities.Saus;

/**
 * Servlet implementation class IngreidentenServlet
 */
@WebServlet("/sauzen/ingredienten.htm")
public class IngredientenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/ingredienten.jsp";
	private static final SausDAO sausDao = new SausDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngredientenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("ingredient") != null && !request.getParameter("ingredient").isEmpty()) {
			List<Saus> ingSauzen = sausDao.findSausByIngredient(request.getParameter("ingredient"));
			request.setAttribute("ingSauzen", ingSauzen);
		} else {
			request.setAttribute("fout", "Geef een ingredient in");
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
