package be.vdab.servlets;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GeslachtServlet
 */
@WebServlet("/geslacht.htm")
public class GeslachtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/geslacht.jsp";   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeslachtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Optional<Cookie> cookie = Arrays.stream(request.getCookies()).filter(c -> c.getName().equals("geslacht")).findFirst();
		if(cookie.isPresent()) {
			String geslacht = URLDecoder.decode(cookie.get().getValue(), "UTF-8");
			String achtergrond, tekst;
			if(geslacht.equals("meisjes")) {
				achtergrond = "pink";
				tekst = "red";
			} else {
				achtergrond = "lightblue";
				tekst = "blue";
			}
			request.setAttribute("achtergrond", achtergrond);
			request.setAttribute("tekst", tekst);
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("geslacht") != null && !request.getParameter("geslacht").isEmpty()) {
			request.setCharacterEncoding("UTF-8");
			Cookie cookie = new Cookie("geslacht", URLEncoder.encode(request.getParameter("geslacht"), "UTF-8"));
			cookie.setMaxAge(60*30);
			response.addCookie(cookie);
			response.sendRedirect(request.getRequestURI());
		}
	}

}
