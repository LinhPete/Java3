package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import DAO.NewsDAO;
import Entity.News;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet({ "/user/home", "/user/culture", "/user/law", "/user/sports", "/user/travel", "/user/tech",
		"/user/detail/*" })
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "photo";
    News form = new News();

	public NewsServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		List<News> newsList = null;
		List<News> homePageList = null;
		List<News> latestList = null;
		List<News> mostViewdList = null;
		List<News> ViewdList = null;
		
		if (uri.contains("home")) {
			try {
				newsList = NewsDAO.getAllHomeNews();
				homePageList = NewsDAO.getAllHomeNews();
				latestList = NewsDAO.getLatestNews();
				mostViewdList = NewsDAO.getTopNewsByViews();
//				ViewdList = NewsDAO.getRecentlyViewedNewsByUser();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("newsList", newsList);
			request.setAttribute("homePageList", homePageList);
			request.setAttribute("latestList", latestList);
			request.setAttribute("mostViewdList", mostViewdList);
//			request.setAttribute("ViewdList", ViewdList);

			String logout = request.getParameter("logout");
			if (Boolean.parseBoolean(logout)) {
				request.getSession().setAttribute("currUser", null);
			}
			request.setAttribute("view", "/user/views/home.jsp");

		} else if (uri.contains("culture")) {
			try {
				newsList = NewsDAO.getNewsByCategory("Văn hoá");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("newsList", newsList);
			request.setAttribute("view", "/user/views/newsList.jsp");

		} else if (uri.contains("law")) {
			try {
				newsList = NewsDAO.getNewsByCategory("Pháp luật");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("newsList", newsList);
			request.setAttribute("view", "/user/views/newsList.jsp");

		} else if (uri.contains("sports")) {
			try {
				newsList = NewsDAO.getNewsByCategory("Thể thao");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("newsList", newsList);
			request.setAttribute("view", "/user/views/newsList.jsp");

		} else if (uri.contains("travel")) {
			try {
				newsList = NewsDAO.getNewsByCategory("Du lịch");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("newsList", newsList);
			request.setAttribute("view", "/user/views/newsList.jsp");

		} else if (uri.contains("tech")) {
			try {
				newsList = NewsDAO.getNewsByCategory("Công nghệ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("newsList", newsList);
			request.setAttribute("view", "/user/views/newsList.jsp");

		} else if (uri.contains("register")) {
			request.setAttribute("view", "/user/views/register.jsp");

		} else if (uri.contains("login")) {
			request.setAttribute("view", "/user/views/login.jsp");

		} else if (uri.contains("demo")) {
			try {
				newsList = NewsDAO.getAllNews();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("newsList", newsList);
			request.setAttribute("view", "/user/views/newsList.jsp");
		}

		else if (uri.contains("detail")) {
			String id = request.getPathInfo().substring(1);
			try {
				News news = NewsDAO.getNewsById(Integer.parseInt(id));
				request.setAttribute("news", news);

				List<News> relatedNews = NewsDAO.getRelatedNews(news.getCategoryId(), news.getId());
				request.setAttribute("relatedNewsList", relatedNews);
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("view", "/user/views/newsDetail.jsp");

		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
}
