/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.auth;

/**
 *
 * @author ndhlt
 */
public class Auth {
	private static User user;

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		Auth.user = user;
	}

	public static void clear() {
		Auth.user = null;
	}

	public static boolean isLogin() {
		return Auth.user != null;
	}

	public static boolean isAdmin() {
		return Auth.isLogin() && Auth.user.getRole() == User.ADMIN;
	}
}
