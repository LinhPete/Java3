package DAO;

import java.sql.*;
//import java.util.ArrayList;
import java.util.List;

import Entity.Categories;
import Entity.News;
import util.other.DataSourceFactory;

public class CategoryDAO {
//    private Connection connection;
//
//    public CategoryDAO(Connection connection) {
//        this.connection = connection;
//    }

    public static void addCategory(Categories cate) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO CATEGORIES (Name) VALUES (?)";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, id);
//            stmt.setString(2, name);
//            stmt.executeUpdate();
//        }
        DataSourceFactory.IUD(sql,cate.toInsertData());
    }

    public static void updateCategory(Categories cate) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE CATEGORIES SET Name = ? WHERE Id = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, name);
//            stmt.setString(2, id);
//            stmt.executeUpdate();
//        }
        DataSourceFactory.IUD(sql, cate.toUpdateData());
    }

    public static void deleteCategory(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM CATEGORIES WHERE Id = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, id);
//            stmt.executeUpdate();
//        }
        DataSourceFactory.IUD(sql, id);
    }
    
    public static Categories getCategoryById(int id) throws SQLException {
    	String sql = "SELECT * FROM CATEGORIES WHERE Id=?";
    	Categories cate = DataSourceFactory.getSingleResult(Categories.class, sql, id);
        
//        try (PreparedStatement stmt = connection.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                newsList.add(rs.getString("Title"));
//            }
//        }
        return cate;
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
