package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public void addUser(String id, String password, String fullname, Date birthday, boolean gender, String mobile, String email, boolean role) throws SQLException {
        String sql = "INSERT INTO USERS (Id, Password, Fullname, Birthday, Gender, Mobile, Email, Role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.setString(2, password);
            stmt.setString(3, fullname);
            stmt.setDate(4, birthday);
            stmt.setBoolean(5, gender);
            stmt.setString(6, mobile);
            stmt.setString(7, email);
            stmt.setBoolean(8, role);
            stmt.executeUpdate();
        }
    }

    public void updateUser(String id, String password, String fullname, Date birthday, boolean gender, String mobile, String email, boolean role) throws SQLException {
        String sql = "UPDATE USERS SET Password = ?, Fullname = ?, Birthday = ?, Gender = ?, Mobile = ?, Email = ?, Role = ? WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, password);
            stmt.setString(2, fullname);
            stmt.setDate(3, birthday);
            stmt.setBoolean(4, gender);
            stmt.setString(5, mobile);
            stmt.setString(6, email);
            stmt.setBoolean(7, role);
            stmt.setString(8, id);
            stmt.executeUpdate();
        }
    }

    public void deleteUser(String id) throws SQLException {
        String sql = "DELETE FROM USERS WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }

    public List<String> getAllUsers() throws SQLException {
        List<String> users = new ArrayList<>();
        String sql = "SELECT * FROM USERS";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                users.add(rs.getString("Fullname"));
            }
        }
        return users;
    }
}

