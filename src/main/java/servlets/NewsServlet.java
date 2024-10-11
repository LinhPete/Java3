package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import DAO.NewsDAO;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet({
			"/user/home",
			"/user/culture",
			"/user/law",
			"/user/sports",
			"/user/travel",
			"/user/tech",
			"/user/login",
			"/user/register"})
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();

		if (uri.contains("home")) {
			req.setAttribute("view", "/user/views/home.jsp");
			
		} else if (uri.contains("culture")) {
			req.setAttribute("view", "/user/views/listCultureNews.jsp");

		} else if (uri.contains("law")) {
			req.setAttribute("view", "/user/views/listLawNews.jsp");

		} else if (uri.contains("sports")) {
			req.setAttribute("view", "/user/views/listSportsNews.jsp");

		} else if (uri.contains("travel")) {
			req.setAttribute("view", "/user/views/listTravelNews.jsp");

		} else if (uri.contains("tech")) {
			req.setAttribute("view", "/user/views/listTechNews.jsp");

		} else if (uri.contains("register")) { 
			req.setAttribute("view", "/user/views/register.jsp");

		} else if (uri.contains("login")) {
			req.setAttribute("view", "/user/views/login.jsp");
		} 
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
//			NewsServlet news = NewsDAO.getNewsById(Integer.parseInt(id));
//			request.setAttribute("news", news);
		}
		request.getRequestDispatcher("/views/newsDetail.jsp").forward(request, response);
	}
}
