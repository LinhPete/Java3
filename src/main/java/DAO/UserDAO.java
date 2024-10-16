package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.News;
import Entity.Users;
import util.other.XJdbc;

public class UserDAO {
//    private Connection connection;
//
//    public UserDAO(Connection connection) {
//        this.connection = connection;
//    }

    public static void addUser(Users user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO USERS (Username, Password, Fullname, Birthday, Gender, Mobile, Email, Role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, id);
//            stmt.setString(2, password);
//            stmt.setString(3, fullname);
//            stmt.setDate(4, birthday);
//            stmt.setBoolean(5, gender);
//            stmt.setString(6, mobile);
//            stmt.setString(7, email);
//            stmt.setBoolean(8, role);
//            stmt.executeUpdate();
//        }
        XJdbc.IUD(sql, user.toInsertData());
    }

	public static void addUser(String email, String password, boolean role)
			throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO USERS (Email, Password, Role) VALUES (?, ?, ?)";
		XJdbc.IUD(sql, email, password, role);
	}

    public static void updateUser(Users user) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE USERS SET Email = ?, Password = ?, Fullname = ?, Username = ?, Birthday = ?, Gender = ?, Mobile = ?, Role = ? WHERE Id = ?";
        XJdbc.IUD(sql, user.toUpdateData());
    }

    public static void deleteUser(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM USERS WHERE Id = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, id);
//            stmt.executeUpdate();
//        }
        XJdbc.IUD(sql, id);
    }

    public static Users getUserById(int id) throws SQLException {
    	String sql = "SELECT * FROM USERS WHERE Id=?";
    	Users user = XJdbc.getSingleResult(Users.class, sql, id);

//        try (PreparedStatement stmt = connection.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                newsList.add(rs.getString("Title"));
//            }
//        }
        return user;
    }

	public static List<Users> getAllUsers() throws SQLException {
		String sql = "SELECT * FROM USERS";
		List<Users> users = XJdbc.getResultList(Users.class, sql);
//        try (PreparedStatement stmt = connection.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                users.add(rs.getString("Fullname"));
//            }
//        }
		return users;
	}

	public static Users getUserByEmail(String email) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM USERS WHERE Email = ?";
		List<Users> users = XJdbc.getResultList(Users.class, sql, email);
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null; // null nếu không tìm thấy user
	}
	
	public static int generateNewId() throws ClassNotFoundException, SQLException {
		String sql = "select top 1 Id from USERS order by Id desc";
		return (int) XJdbc.getValue(sql) +1;
	}
}
