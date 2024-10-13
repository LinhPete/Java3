package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.encrypt.PasswordUtil;

import java.io.IOException;
import java.sql.SQLException;

import DAO.UserDAO;
import Entity.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({"/user/login", "/user/logout"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		if(path.contains("login")) {
		request.setAttribute("view", "/user/views/login.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else if(path.contains("logout")) {
				request.getSession().setAttribute("currUser", null);
				response.sendRedirect("/SOF203_ASM/user/home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (email != null && password != null) {
			try {
				Users user = UserDAO.getUserByEmail(email);
				if (user != null) {
					if (PasswordUtil.checkPassword(password, user.getPassword())) {
						request.getSession().setAttribute("currUser", user);
//						request.setAttribute("view", "/user/views/home.jsp");
						response.sendRedirect("/SOF203_ASM/user/home");
						return;
					} else {
						request.setAttribute("error", "Mật khẩu không đúng");
						request.setAttribute("view", "/user/views/login.jsp");
					}
				} else {
					request.setAttribute("error", "Email không tồn tại");
					request.setAttribute("view", "/user/views/login.jsp");
				}
			} catch (SQLException | ClassNotFoundException ex) {
				request.setAttribute("error", "Có lỗi xảy ra");
				request.setAttribute("view", "/user/views/login.jsp");
			}
		} else {
			request.setAttribute("error", "Vui lòng điền đầy đủ thông tin");
			request.setAttribute("view", "/user/views/login.jsp");
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
