package be.vdab.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.dao.SausDAO;

/**
 * Servlet implementation class SausRadenServlet
 */
@WebServlet("/sausraden.htm")
public class SausRadenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/sausraden.jsp";
	private static final SausDAO sausDao = new SausDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SausRadenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("saus") == null) {
			initSpelSession(session);
		}
		request.setAttribute("saus", session.getAttribute("saus"));
		request.setAttribute("dotted", new String((char[])session.getAttribute("dotted")));
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
	
	private void initSpelSession(HttpSession s) {
		String saus = sausDao.getRandomSaus().getNaam();
		s.setAttribute("saus", saus);
		char[] dotted = new char[saus.length()];
		for(int i = 0; i < dotted.length;i++) {
			dotted[i] = '.';
		}
		s.setAttribute("pogingen", 0);
		s.setAttribute("dotted", dotted);
		s.setAttribute("found", false);
	}
	
	private static boolean isSausFound(char[] dotted) {
		int hits = 0;
		for(int i = 0; i < dotted.length;i++) {
			if(dotted[i] == '.') hits++;
		}
		return hits == 0;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(request.getParameter("nieuwBtn") != null) {
			initSpelSession(session);
		}
		if(request.getParameter("radenBtn") != null) {
			int hits = 0;
			char letter = request.getParameter("letterField").charAt(0);
			char[] dotted = (char[]) session.getAttribute("dotted");
			String saus = (String) session.getAttribute("saus");
			for(int i= 0; i < dotted.length;i++) {
				if(saus.charAt(i) == letter) {
					dotted[i] = letter;
					hits++;
				}
			}
			if(isSausFound((char[]) session.getAttribute("dotted"))) session.setAttribute("found", true);
			if(hits ==0) session.setAttribute("pogingen", (int) session.getAttribute("pogingen") + 1);
			session.setAttribute("dotted", dotted);
			session.setAttribute("saus", saus);
		}
		doGet(request, response);
	}

}
