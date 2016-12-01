package be.vdab.servlets;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Adres;
import be.vdab.entities.Gemeente;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns="/index.html", name="indexservlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	private final Adres adres = new Adres();
	private final Gemeente gemeente = new Gemeente();

    /**
     * Default constructor. 
     * @return 
     */
    public void init() throws ServletException {
    	adres.setStraat(this.getInitParameter("straat"));
		adres.setHuisNr(this.getInitParameter("huisnummer"));
		gemeente.setNaam(this.getInitParameter("gemeente"));
		gemeente.setPostCode(Integer.parseInt(this.getInitParameter("postcode")));
		adres.setGemeente(gemeente);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dag = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		String openGesloten = (dag == Calendar.MONDAY || dag == Calendar.THURSDAY) ? "gesloten" : "open";

		request.setAttribute("adres", adres);
		request.setAttribute("openGesloten", openGesloten);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
