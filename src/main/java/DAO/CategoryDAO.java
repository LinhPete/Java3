package DAO;

import java.sql.*;
//import java.util.ArrayList;
import java.util.List;

import Entity.Categories;
import util.other.DataSourceFactory;

public class CategoryDAO {
//    private Connection connection;
//
//    public CategoryDAO(Connection connection) {
//        this.connection = connection;
//    }

    public static void addCategory(String id, String name) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO CATEGORIES (Id, Name) VALUES (?, ?)";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, id);
//            stmt.setString(2, name);
//            stmt.executeUpdate();
//        }
        DataSourceFactory.IUD(sql, id, name);
    }

    public static void updateCategory(String id, String name) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE CATEGORIES SET Name = ? WHERE Id = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, name);
//            stmt.setString(2, id);
//            stmt.executeUpdate();
//        }
        DataSourceFactory.IUD(sql, name, id);
    }

    public static void deleteCategory(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM CATEGORIES WHERE Id = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, id);
//            stmt.executeUpdate();
//        }
        DataSourceFactory.IUD(sql, id);
    }

    public static List<Categories> getAllCategories() throws SQLException {
    	String sql = "SELECT * FROM CATEGORIES";
        List<Categories> categories = DataSourceFactory.getResultList(Categories.class, sql);
//        try (PreparedStatement stmt = connection.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                categories.add(rs.getString("Name"));
//            }
//        }
        return categories;
    }
}
