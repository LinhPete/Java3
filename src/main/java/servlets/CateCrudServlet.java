package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.CategoryDAO;
import DAO.NewsDAO;
import Entity.Categories;
import Entity.News;

/**
 * Servlet implementation class CateCrudServlet
 */
@WebServlet({"/category" })
public class CateCrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		try {
			List<Categories> list = CategoryDAO.getAllCategories();
			request.setAttribute("list", list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (id != null) {
			try {
				Categories category = CategoryDAO.getCategoryById(Integer.parseInt(id));
				request.setAttribute("category", category);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Logger.getLogger(CateCrudServlet.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		if(request.getMethod().equalsIgnoreCase("post")) {
			doPost(request, response);
		}
		request.setAttribute("dst", "category");
		request.getRequestDispatcher("/admin/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int action = Integer.parseInt(request.getParameter("action"));
		switch (action) {
		case 0:
			String name = request.getParameter("newCate");
			Categories newcate = new Categories();
			newcate.setName(name);
			try {
				CategoryDAO.addCategory(newcate);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		request.setAttribute("dst", "category");
//		request.getRequestDispatcher("/admin/views/index.jsp").forward(request, response);
	}

}
