package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private Connection connection;

    public CategoryDAO(Connection connection) {
        this.connection = connection;
    }

    public void addCategory(String id, String name) throws SQLException {
        String sql = "INSERT INTO CATEGORIES (Id, Name) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.executeUpdate();
        }
    }

    public void updateCategory(String id, String name) throws SQLException {
        String sql = "UPDATE CATEGORIES SET Name = ? WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, id);
            stmt.executeUpdate();
        }
    }

    public void deleteCategory(String id) throws SQLException {
        String sql = "DELETE FROM CATEGORIES WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }

    public List<String> getAllCategories() throws SQLException {
        List<String> categories = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIES";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                categories.add(rs.getString("Name"));
            }
        }
        return categories;
    }
}
