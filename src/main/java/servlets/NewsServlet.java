package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DAO.NewsDAO;
import DAO.UserDAO;
import Entity.News;
import Entity.Users;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet({ "/user/home", "/user/culture", "/user/law", "/user/sports", "/user/travel", "/user/tech",
		"/user/detail/*", "/user/search" })
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
		
	    String path = request.getServletPath();
		String uri = request.getRequestURI();
		List<News> newsList = null;
		List<News> homePageList = null;
		List<News> latestList = null;
		List<News> mostViewdList = null;
		List<News> viewdList = null;

		if (uri.contains("home")) {
			try {
				newsList = NewsDAO.getAllHomeNews();
				homePageList = NewsDAO.getAllHomeNews();
				latestList = NewsDAO.getLatestNews();
				mostViewdList = NewsDAO.getTopNewsByViews();
				
				viewdList = new ArrayList<>();
				String[] viewedIds = null;
				Cookie[] cookies = request.getCookies();
				if(cookies!=null) {
					for(int i = 0;i<cookies.length;i++) {
						if(cookies[i].getName().equals("viewedArticles")) {
							viewedIds = cookies[i].getValue().split(",");
							break;
						}
					}
				}
				
				if(viewedIds != null) {
					for(String id: viewedIds) {
						News news = NewsDAO.getNewsById(Integer.parseInt(id));
						viewdList.add(news);
						if(viewdList.size()==6) {break;}
					}
				}
				

			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("newsList", newsList);
			request.setAttribute("homePageList", homePageList);
			request.setAttribute("latestList", latestList);
			request.setAttribute("mostViewdList", mostViewdList);
			request.setAttribute("view", "/user/views/home.jsp");
			request.setAttribute("viewdList", viewdList);
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

		} else if (uri.contains("detail")) {
			String id = request.getPathInfo().substring(1);
			
			try {
				News news = NewsDAO.getNewsById(Integer.parseInt(id));
				request.setAttribute("news", news);
				Cookie viewedArticlesCookie = null;
				Cookie[] cookies = request.getCookies();
				for(int i = 0;i<cookies.length;i++) {
					if(cookies[i].getName().equals("viewedArticles")) {
						cookies[i].setValue(news.getId()+","+cookies[i].getValue());
						viewedArticlesCookie = cookies[i];
						break;
					}
				}
				if(viewedArticlesCookie == null) {
					viewedArticlesCookie = new Cookie("viewedArticles", news.getId()+"");
					viewedArticlesCookie.setMaxAge(60*60*24); // Cookie tồn tại trong 24 giờ
					response.addCookie(viewedArticlesCookie);
				}			
				
				List<News> relatedNews = NewsDAO.getRelatedNews(news.getCategoryId(), news.getId());
				request.setAttribute("relatedNewsList", relatedNews);
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("view", "\\user\\views\\newsDetail.jsp");
			
		} else if (path.contains("search") && !request.getParameter("search").isBlank()){
			List<News> list;
		    String searchQuery = request.getParameter("search");
		        try {
		            list = NewsDAO.searchNews(searchQuery);
		            request.setAttribute("newsList", list);
		        } catch (SQLException e) {
		            e.printStackTrace();
		    }
		    request.setAttribute("view", "/user/views/newsList.jsp");
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	public String updatedArticleIds(String currentIds, String newArticleId) {
	    // Giả sử các ID bài viết được phân tách bằng dấu phẩy ","
	    List<String> articleIdsList = new ArrayList<>(Arrays.asList(currentIds.split(",")));

	    // Loại bỏ ID bài viết cũ nếu đã tồn tại trong danh sách
	    articleIdsList.remove(newArticleId);

	    // Thêm bài viết mới lên đầu danh sách
	    articleIdsList.add(0, newArticleId);

	    // Giới hạn danh sách chỉ chứa tối đa 5 bài viết gần đây
	    if (articleIdsList.size() > 5) {
	        articleIdsList = articleIdsList.subList(0, 5);
	    }

	    // Kết hợp các ID lại thành chuỗi để lưu vào cookie
	    return String.join(",", articleIdsList);
	}

}
