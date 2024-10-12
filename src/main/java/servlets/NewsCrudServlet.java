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
import java.util.Date;
import java.util.List;
import DAO.CategoryDAO;
import DAO.NewsDAO;
import Entity.Categories;
import Entity.News;
import Entity.Users;

/**
 * Servlet implementation class NewsCrudServlet
 */
@WebServlet({"/admin/news","/admin/news/edit/*","/admin/news/blank","/admin/news/create","/admin/news/update","/admin/news/delete","/admin/news/reset"})
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
		setUser((Users) request.getSession().getAttribute("user"));
		String id = request.getParameter("id");
		if(id==null || id.isBlank()) {
			String search = request.getParameter("search");
			try {
				List<News> list;
				if(search!=null&&!search.isBlank()) {
					list = NewsDAO.searchNews(search);
				}
				else if(user==null||user.getRole()) {
					list = NewsDAO.getAllNews();
				}
				else {
					list = NewsDAO.getAllNewsByAuthor(user.getId());
				}
				request.setAttribute("list", list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("path", "/admin/views/newsList.jsp");
		}
		else {
			try {
				List<Categories> categories = CategoryDAO.getAllCategories();
				news = NewsDAO.getNewsById(Integer.parseInt(id));
				request.setAttribute("news", news);
				request.setAttribute("categories", categories);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("path", "/admin/views/newsDetail.jsp");
		}
		request.getRequestDispatcher("/admin/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Part img = request.getPart("img");
		File saveDir = new File(request.getServletContext().getRealPath("/uploads"));
		if(!saveDir.exists()) {
			saveDir.mkdirs();
		}
		String path = "/uploads/" + img.getSubmittedFileName();
		String fileName = request.getServletContext().getRealPath(path);
		img.write(fileName);

		news.setTitle(request.getParameter("title"));
		news.setContent(request.getParameter("content"));
		news.setImage(img.getSubmittedFileName());
		news.setCategoryId(Integer.parseInt(request.getParameter("category")));
		news.setPostedDate(new Date());
		
		try {
			NewsDAO.updateNews(news);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("dst", "newsList");
		request.getRequestDispatcher("/admin/views/index.jsp").forward(request, response);
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
