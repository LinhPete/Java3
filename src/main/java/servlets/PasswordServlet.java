package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.encrypt.AES;
import util.encrypt.PasswordUtil;
import util.other.XMailer;

import java.io.IOException;
import java.sql.SQLException;

import DAO.UserDAO;
import Entity.Users;

/**
 * Servlet implementation class PasswordServlet
 */
@WebServlet({"/user/changePass","/user/forgetPass","/user/forgetPass/confirm"})
public class PasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String key;

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
		else if(path.contains("forgetPass")) {
			if(request.getSession().getAttribute("isConfirm")==null) {
				request.getSession().setAttribute("isConfirm", false);
			}
			request.setAttribute("view", "/user/views/forgetPass.jsp");
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
		if (path.endsWith("changePass")) {
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
				try {
					UserDAO.updateUser(currUser);
					request.getSession().setAttribute("currUser", null);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("view", "/user/views/login.jsp");
			}
		}
		else if(path.endsWith("forgetPass")) {
			boolean isConfirm = (boolean) request.getSession().getAttribute("isConfirm");
			if(isConfirm) {
				String newPass = request.getParameter("newPassword");
				String confirmPass = request.getParameter("confirmPassword");
				if(newPass.equals(confirmPass)) {
					try {
						Users temp = UserDAO.getUserById((int) request.getSession().getAttribute("passChangeId"));
						temp.setPassword(PasswordUtil.hashPassword(newPass));
						UserDAO.updateUser(temp);
						request.getSession().setAttribute("currUser", null);
						response.sendRedirect("/SOF203_ASM/user/login");
						return;
					} catch (SQLException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				String email = request.getParameter("email");
				try {
					Users temp = UserDAO.getUserByEmail(email);
					if(temp!=null) {
						key = generateConfirmKey();
						boolean isSent = XMailer.send(email, "Mã xác nhận", key);
						if (isSent) {
							request.getSession().setAttribute("confirmKey", key);
							request.getSession().setAttribute("passChangeId", temp.getId());
							request.setAttribute("formAction", "/forgetPass/confirm");
							request.getRequestDispatcher("/user/views/confirmEmail.jsp").forward(request, response);
							return;
						} else {
							request.setAttribute("error", "Có lỗi xảy ra");
							request.setAttribute("view", "/user/views/register.jsp");
						}
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else if(path.endsWith("confirm")) {
			request.getSession().setAttribute("isConfirm", true);
			response.sendRedirect("/SOF203_ASM/user/forgetPass");
			return;
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
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
