package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.News;
import util.other.DataSourceFactory;
import util.other.XJdbc;

public class NewsDAO {
//    private Connection connection;
//
//    public NewsDAO(Connection connection) {
//        this.connection = connection;
//    }

    public static void addNews(News news) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO NEWS (Title, Content, Image, PostedDate, Author, ViewCount, CategoryId, Home) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, id);
//            stmt.setString(2, title);
//            stmt.setString(3, content);
//            stmt.setString(4, image);
//            stmt.setDate(5, postedDate);
//            stmt.setString(6, author);
//            stmt.setInt(7, viewCount);
//            stmt.setString(8, categoryId);
//            stmt.setBoolean(9, home);
//            stmt.executeUpdate();
//        }
        DataSourceFactory.IUD(sql, news.toInsertData());
    }

    public static void updateNews(News news) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE NEWS SET Title = ?, Content = ?, Image = ?, PostedDate = ?, Author = ?, ViewCount = ?, CategoryId = ?, Home = ? WHERE Id = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, title);
//            stmt.setString(2, content);
//            stmt.setString(3, image);
//            stmt.setDate(4, postedDate);
//            stmt.setString(5, author);
//            stmt.setInt(6, viewCount);
//            stmt.setString(7, categoryId);
//            stmt.setBoolean(8, home);
//            stmt.setString(9, id);
//            stmt.executeUpdate();
//        }
        DataSourceFactory.IUD(sql, news.toUpdateData());
    }

    public static void deleteNews(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM NEWS WHERE Id = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, id);
//            stmt.executeUpdate();
//        }
        DataSourceFactory.IUD(sql, id);
    }
    
    public static News getNewsById(int id) throws SQLException {
    	String sql = "SELECT * FROM NEWS WHERE Id=?";
    	News news = DataSourceFactory.getSingleResult(News.class, sql, id);
        
//        try (PreparedStatement stmt = connection.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                newsList.add(rs.getString("Title"));
//            }
//        }
        return news;
    }

    public static List<News> getAllNews() throws SQLException {
    	String sql = "SELECT * FROM NEWS";
    	List<News> newsList = DataSourceFactory.getResultList(News.class, sql);
        
//        try (PreparedStatement stmt = connection.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                newsList.add(rs.getString("Title"));
//            }
//        }
        return newsList;
    }
    
    public static List<News> getAllHomeNews() throws SQLException {
    	String sql = "SELECT * FROM NEWS WHERE HOME = 1";
    	List<News> newsList = DataSourceFactory.getResultList(News.class, sql);
        
//        try (PreparedStatement stmt = connection.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                newsList.add(rs.getString("Title"));
//            }
//        }
        return newsList;
    }
    
    public static List<News> getAllNewsByAuthor(int authorID) throws SQLException {
    	String sql = "SELECT * FROM NEWS WHERE Author = ?";
    	List<News> newsList = DataSourceFactory.getResultList(News.class, sql, authorID);
        
//        try (PreparedStatement stmt = connection.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                newsList.add(rs.getString("Title"));
//            }
//        }
        return newsList;
    }
}
