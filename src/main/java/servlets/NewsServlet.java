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
@WebServlet("/home")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  String page = request.getParameter("page");
		  String id = request.getParameter("id");

        if (page == null || page.equals("home")) {
            request.getRequestDispatcher("/user/views/home.jsp").forward(request, response);
        } else if (page.equals("culture")) {
            request.getRequestDispatcher("/user/views/listCultureNews.jsp").forward(request, response);
        } else if (page.equals("law")) {
            request.getRequestDispatcher("/user/views/listLawNews.jsp").forward(request, response);
        } else if (page.equals("sports")) {
            request.getRequestDispatcher("/user/views/listSportsNews.jsp").forward(request, response);
        } else if (page.equals("travel")) {
            request.getRequestDispatcher("/user/views/listTravelNews.jsp").forward(request, response);
        } else if (page.equals("tech")){
            request.getRequestDispatcher("/user/views/listTechNews.jsp").forward(request, response);
        }else if (page.equals("register")){
            request.getRequestDispatcher("/user/views/register.jsp").forward(request, response);
        }else if (page.equals("login")){
            request.getRequestDispatcher("/user/views/login.jsp").forward(request, response);
        }
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
