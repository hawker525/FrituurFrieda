package be.vdab.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ZoekFrietServlet
 */
@WebServlet("/zoekdefriet.htm")
public class ZoekFrietServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/zoekdefriet.jsp";
	private static int FRIET;
	private static final Map<Integer, String> KEUZES = new HashMap<>(); 
	
	private static void initSpel() {
			for(int i =0; i < 7;i++) {
				KEUZES.put(i, "deurtoe");
			}
			FRIET = new Random().nextInt(7);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZoekFrietServlet() {
        super();
        initSpel();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nieuw = request.getParameter("nieuwBtn");
		if(nieuw != null && nieuw.equals("nieuw")) {
			initSpel();
		}
		String deur = request.getParameter("volgnummer");
		if(deur != null) {
			if(Integer.parseInt(deur) == FRIET) {
				KEUZES.put(Integer.parseInt(deur), "gevonden");
			} else {
				KEUZES.put(Integer.parseInt(deur), "deuropen");
			}
		}
		request.setAttribute("keuzes", KEUZES);
		request.setAttribute("FRIET", String.valueOf(FRIET));
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
