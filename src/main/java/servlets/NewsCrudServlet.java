package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import DAO.CategoryDAO;
import DAO.NewsDAO;
import DAO.UserDAO;
import Entity.Categories;
import Entity.News;
import Entity.Users;

/**
 * Servlet implementation class NewsCrudServlet
 */
@WebServlet({"/admin/news","/admin/news/edit/*","/admin/news/blank","/admin/news/create","/admin/news/update","/admin/news/delete","/admin/news/reset","/admin/news/search"})
public class NewsCrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private News news;
	private Users user;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsCrudServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<News> list;
		String path = request.getServletPath();
		setUser((Users) request.getSession().getAttribute("user"));
		if(path.contains("search") && !request.getParameter("search").isBlank()) {
			try {
				list = NewsDAO.searchNews(request.getParameter("search"));
				request.setAttribute("list", list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("path", "/admin/views/newsList.jsp");
		} else if(path.contains("edit")) {
			String id = request.getPathInfo().substring(1);
			try {
				news = NewsDAO.getNewsById(Integer.parseInt(id));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("news", news);
			List<Categories> categories;
			try {
				categories = CategoryDAO.getAllCategories();
				request.setAttribute("categories", categories);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("path", "/admin/views/newsDetail.jsp");
		}
		else if(path.contains("blank")) {
			news = new News();
			try {
				news.setId(NewsDAO.generateNewId());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("news", news);
			List<Categories> categories;
			try {
				categories = CategoryDAO.getAllCategories();
				request.setAttribute("categories", categories);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("path", "/admin/views/newsDetail.jsp");
		}
		else {
			try {
				list = NewsDAO.getAllNews();
				request.setAttribute("list", list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("path", "/admin/views/newsList.jsp");
		}
		request.getRequestDispatcher("/admin/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DateTimeConverter dtc = new DateConverter(new Date());
		dtc.setPattern("MM/dd/yyyy");
		ConvertUtils.register(dtc, Date.class);
		String uri = request.getServletPath();
		if (uri.contains("create")) {
			try {
				BeanUtils.populate(news, request.getParameterMap());
				Part img = request.getPart("img");
				upload(request, img);
				news.setImage(img.getSubmittedFileName());
				news.setPostedDate(new Date());
				news.setAuthor(((News) request.getSession().getAttribute("user")).getId());
				NewsDAO.addNews(news);
				request.setAttribute("news", news);
				request.setAttribute("action", "edit");
			} catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (uri.contains("update")) {
			try {
				BeanUtils.populate(news, request.getParameterMap());
				Part img = request.getPart("img");
				if(img!=null && !img.getSubmittedFileName().isBlank()) {
					upload(request, img);
					news.setImage(img.getSubmittedFileName());
				}
				news.setPostedDate(new Date());
				NewsDAO.updateNews(news);
				request.setAttribute("news", news);
				request.setAttribute("action", "edit");
			} catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (uri.contains("delete")) {
			try {
				NewsDAO.deleteNews(news.getId());
				news = new News();
				news.setId(NewsDAO.generateNewId());
				request.setAttribute("news", news);
				request.setAttribute("action", "edit");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (uri.contains("reset")) {
			news = new News();
			try {
				news.setId(UserDAO.generateNewId());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("news", news);
			request.setAttribute("action", "create");
		}
		request.setAttribute("path", "/admin/views/newsDetail.jsp");
		request.getRequestDispatcher("/admin/views/index.jsp").forward(request, response);
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	private void upload(HttpServletRequest request, Part img) throws IOException {
		File saveDir = new File(request.getServletContext().getRealPath("/uploads"));
		if(!saveDir.exists()) {
			saveDir.mkdirs();
		}
		String path = "/uploads/" + img.getSubmittedFileName();
		String fileName = request.getServletContext().getRealPath(path);
		img.write(fileName);
	}
}
