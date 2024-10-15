package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.other.XMailer;

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
@WebServlet({"/admin/letter", "/admin/letter/edit/*", "/admin/letter/update", "/admin/letter/delete", "/user/subscribe"})
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
		} else if (path.contains("/user/subcribe")) {
			String email = request.getParameter("email");
			Boolean check = NewsLettersDAO.checkEnabled(email);
			if(check) {
				response.sendRedirect("/SOF203_ASM/user/home");
				return;
			}
			String key = generateConfirmKey();
			boolean isSent = XMailer.send(email, "Mã xác nhận", key);
			if (isSent) {
				request.getSession().setAttribute("confirmKey", key);
				request.getSession().setAttribute("newsLetter", email);
				request.setAttribute("formAction", "/subscribe/confirm");
				request.getRequestDispatcher("/user/views/confirmEmail.jsp").forward(request, response);
				return;
			}
		} else if (path.contains("/user/subcribe/confirm")) {
			String email = (String) request.getSession().getAttribute("newsLetter");
			Boolean check = NewsLettersDAO.checkEnabled(email);
			if(check==null) {
				try {
					NewsLettersDAO.addNewsletter(new Newsletters(email, true));
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(!check) {
				try {
					NewsLettersDAO.updateNewsletter(new Newsletters(email, true));
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		request.setAttribute("path", "/admin/views/letter.jsp");
		request.getRequestDispatcher("/admin/views/index.jsp").forward(request, response);
	}

	private String generateConfirmKey() {
		String allowed = "qwertyuiopasdfghjklzxcvbnmMNBVCXZASDFGHJKLPOIUYTREWQ0123456789";
		String key = "";
		for (int i = 0; i < 6; i++) {
			key += allowed.charAt((int) (Math.random() * allowed.length()));
		}
		return key;
	}
}
