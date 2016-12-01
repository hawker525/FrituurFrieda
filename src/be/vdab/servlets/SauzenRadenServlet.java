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
 * Servlet implementation class SauzenRadenServlet
 */
@WebServlet("/sauzenraden.htm")
public class SauzenRadenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/sauzenraden.jsp";
	private static final SausDAO sausDao = new SausDAO();
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SauzenRadenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null){
			session = request.getSession();
			initSessionGame(session);
		}
		request.setAttribute("saus", session.getAttribute("saus"));
		request.setAttribute("dotted", session.getAttribute("dotted"));
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String saus = request.getParameter("saus");
		if(request.getParameter("radenBtn").equals("Raden")){
			char letter = request.getParameter("letter").charAt(0);
			StringBuilder tmp = new StringBuilder((String)session.getAttribute("dotted"));
			for(int i=0;i<tmp.length();i++){
				if(saus.charAt(i) == letter){
					tmp.setCharAt(i, letter);
				}
			}
			session.setAttribute("dotted", tmp.toString());
		}
		doGet(request, response);
	}
	
	private void initSessionGame(HttpSession session){
		String saus = sausDao.getRandomSaus().getNaam();
		String dotted = ".";
		for (int i = 0; i < saus.length()-1; i++) {
			dotted+=".";
		}
		session.setAttribute("saus", saus);
		session.setAttribute("dotted", dotted);
	}

}
