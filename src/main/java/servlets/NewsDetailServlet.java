package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import DAO.NewsDAO;
import Entity.News;

/**
 * Servlet implementation class NewsDetailServlet
 */
@WebServlet("/NewsDetailServlet")
public class NewsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsDAO newsDAO = new NewsDAO();

	public NewsDetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int newsId = Integer.parseInt(request.getParameter("id")); // Lấy ID tin tức từ URL
		News news = null;
		 List<News> relatedNewsList = null;
		 
		 // Lấy tin tức theo ID
		try {
			news = NewsDAO.getNewsById(newsId);
			
			// Lấy danh sách các tin tức liên quan theo cùng categoryId
	        relatedNewsList = newsDAO.getRelatedNews(news.getCategoryId(), newsId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("news", news); // Đặt dữ liệu tin tức vào request
		request.getRequestDispatcher("/views/NewsDetail.jsp").forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
