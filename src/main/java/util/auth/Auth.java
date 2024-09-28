/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.auth;

import Entity.Users;

/**
 *
 * @author ndhlt
 */
public class Auth {
	private static Users user;

	public static Users getUser() {
		return user;
	}

	public static void setUser(Users user) {
		Auth.user = user;
	}

	public static void clear() {
		Auth.user = null;
	}

	public static boolean isLogin() {
		return Auth.user != null;
	}

	public static boolean isAdmin() {
		return Auth.isLogin() && Auth.user.isRole();
	}
}
