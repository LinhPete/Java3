package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.Users;
import util.other.DataSourceFactory;

public class UserDAO {
//    private Connection connection;
//
//    public UserDAO(Connection connection) {
//        this.connection = connection;
//    }

    public static void addUser(String id, String password, String fullname, Date birthday, boolean gender, String mobile, String email, boolean role) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO USERS (Id, Password, Fullname, Birthday, Gender, Mobile, Email, Role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
        DataSourceFactory.IUD(sql, id, password, fullname, birthday, gender, mobile, email, role);
    }

    public static void updateUser(String id, String password, String fullname, Date birthday, boolean gender, String mobile, String email, boolean role) throws SQLException, ClassNotFoundException {
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

    public static void deleteUser(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM USERS WHERE Id = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, id);
//            stmt.executeUpdate();
//        }
        DataSourceFactory.IUD(sql, id);
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
}

