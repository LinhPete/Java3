package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.encrypt.PasswordUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.UserDAO;
import Entity.Users;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/user/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		request.setAttribute("view", "/user/views/register.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lấy thông tin từ form đăng ký
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		if (email != null && password != null) {
			try {
				Users existingUser = UserDAO.getUserByEmail(email);
				if (existingUser != null) {
					request.setAttribute("errorEmail", "Email đã tồn tại, vui lòng sử dụng email khác");
					request.setAttribute("view", "/user/views/register.jsp");
				}

				else if (!password.equals(confirmPassword)) {
					request.setAttribute("errorPassword", "Mật khẩu và mật khẩu xác nhận không khớp");
					request.setAttribute("view", "/user/views/register.jsp");
				}
				else {
					// Mã hóa mật khẩu với SHA-256
					String hashedPassword = PasswordUtil.hashPassword(password);

					// Lưu thông tin người dùng vào cơ sở dữ liệu
					UserDAO.addUser(email, hashedPassword, false);

					// Điều hướng đến trang đăng ký thành công
					request.setAttribute("view", "/user/views/register.jsp");
				}
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				request.setAttribute("error", "Có lỗi xảy ra, vui lòng thử lại sau");
				request.setAttribute("view", "/user/views/register.jsp");
			}
		} else {
			request.setAttribute("error", "Vui lòng điền đầy đủ thông tin");
			request.setAttribute("view", "/user/views/register.jsp");
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
