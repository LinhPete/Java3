package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.News;
import Entity.Users;
import util.other.DataSourceFactory;

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
        DataSourceFactory.IUD(sql, user.toInsertData());
    }

	public static void addUser(String email, String password, boolean role)
			throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO USERS (Email, Password, Role) VALUES (?, ?, ?)";
		DataSourceFactory.IUD(sql, email, password, role);
	}

	public static void updateUser(String password, String fullname, Date birthday, boolean gender,
			String mobile, String email, boolean role, int id) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE USERS SET Password = ?, Fullname = ?, Birthday = ?, Gender = ?, Mobile = ?, Email = ?, Role = ? WHERE Id = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, password);
//            stmt.setString(2, fullname);
//            stmt.setDate(3, birthday);
//            stmt.setBoolean(4, gender);
//            stmt.setString(5, mobile);
//            stmt.setString(6, email);
//            stmt.setBoolean(7, role);
//            stmt.setString(8, id);
//            stmt.executeUpdate();
//        }
		DataSourceFactory.IUD(sql, password, fullname, birthday, gender, mobile, email, role, id);
	}
    public static void updateUser(Users user) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE USERS SET Username = ?, Password = ?, Fullname = ?, Birthday = ?, Gender = ?, Mobile = ?, Email = ?, Role = ? WHERE Id = ?";
        DataSourceFactory.IUD(sql, user.toUpdateData());
    }

    public static void deleteUser(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM USERS WHERE Id = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, id);
//            stmt.executeUpdate();
//        }
        DataSourceFactory.IUD(sql, id);
    }

    public static Users getUserById(int id) throws SQLException {
    	String sql = "SELECT * FROM USERS WHERE Id=?";
    	Users user = DataSourceFactory.getSingleResult(Users.class, sql, id);

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
		List<Users> users = DataSourceFactory.getResultList(Users.class, sql);
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
		List<Users> users = DataSourceFactory.getResultList(Users.class, sql, email);
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null; // null nếu không tìm thấy user
	}
}
