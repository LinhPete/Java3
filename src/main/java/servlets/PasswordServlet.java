package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.encrypt.PasswordUtil;

import java.io.IOException;

import Entity.Users;

/**
 * Servlet implementation class PasswordServlet
 */
public class PasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		if (path.contains("changePass")) {
			request.setAttribute("view", "/user/views/changePass.jsp");
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		if (path.contains("changePass")) {
			String currPass = request.getParameter("currPass");
			String newPass = request.getParameter("newPass");
			String confirmPass = request.getParameter("confirmPass");
			Users currUser = (Users) request.getSession().getAttribute("currUser");
			if(!PasswordUtil.checkPassword(currPass, currUser.getPassword())) {
				request.setAttribute("error", "Mật khẩu hiện tại không khớp");
				request.setAttribute("view", "/user/views/changePass.jsp");
			}
			else if(!newPass.equals(confirmPass)) {
				request.setAttribute("error", "Mật khẩu xác nhận không khớp");
				request.setAttribute("view", "/user/views/changePass.jsp");
			}
			else {
				currUser.setPassword(PasswordUtil.hashPassword(newPass));
				request.setAttribute("view", "/user/views/login.jsp");
			}
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
