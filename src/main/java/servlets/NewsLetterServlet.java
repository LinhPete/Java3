package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import Entity.Newsletters;

import DAO.NewsLettersDAO;

/**
 * Servlet implementation class NewsLetterServlet
 */
@WebServlet({"/admin/letter", "/admin/letter/edit/*", "/admin/letter/update", "/admin/letter/delete"})
public class NewsLetterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Newsletters> list;
	private Newsletters form;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsLetterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		list = NewsLettersDAO.getAllNewsletter();
		String path = request.getServletPath();
		if(path.contains("edit")) {
			int index = Integer.parseInt(request.getPathInfo().substring(1));
			form = list.get(index-1);
			request.setAttribute("item", form);
		}
		else if(path.contains("update")) {
			form.setEmail(request.getParameter("email"));
			form.setEnabled(request.getParameter("enabled")!=null);
			try {
				NewsLettersDAO.updateNewsletter(form);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("item", form);
		}
		else if(path.contains("delete")) {
			try {
				NewsLettersDAO.deleteNewsletter(form.getEmail());
				form = new Newsletters();
				request.setAttribute("item", form);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("path", "/admin/views/letter.jsp");
		request.getRequestDispatcher("/admin/views/index.jsp").forward(request, response);
	}

}
