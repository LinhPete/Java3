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
@WebServlet("/login")
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
		request.getRequestDispatcher("/user/views/login.jsp").forward(request, response);
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
						request.getRequestDispatcher("/user/views/home.jsp").forward(request, response);
					} else {
						request.setAttribute("error", "Mật khẩu không đúng");
						request.getRequestDispatcher("/user/views/login.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("error", "Email không tồn tại");
					request.getRequestDispatcher("/user/views/login.jsp").forward(request, response);
				}
			} catch (SQLException | ClassNotFoundException ex) {
				request.setAttribute("error", "Có lỗi xảy ra");
				request.getRequestDispatcher("/user/views/login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("error", "Vui lòng điền đầy đủ thông tin");
			request.getRequestDispatcher("/user/views/login.jsp").forward(request, response);
		}
	}
}
