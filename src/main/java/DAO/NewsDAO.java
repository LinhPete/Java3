package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Entity.News;
import util.other.XJdbc;
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
		XJdbc.IUD(sql, news.toInsertData());
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
		XJdbc.IUD(sql, news.toUpdateData());
	}

	public static void deleteNews(int id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM NEWS WHERE Id = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, id);
//            stmt.executeUpdate();
//        }
		XJdbc.IUD(sql, id);
	}

	public static News getNewsById(int id) throws SQLException {
		String sql = "SELECT * FROM NEWS WHERE Id=?";
		News news = XJdbc.getSingleResult(News.class, sql, id);

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
		List<News> newsList = XJdbc.getResultList(News.class, sql);

//        try (PreparedStatement stmt = connection.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                newsList.add(rs.getString("Title"));
//            }
//        }
		return newsList;
	}

	public static List<News> getAllHomeNews() throws SQLException {
		String sql = "SELECT TOP 5 * FROM NEWS WHERE HOME = 1";
		List<News> newsList = XJdbc.getResultList(News.class, sql);

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
		List<News> newsList = XJdbc.getResultList(News.class, sql, authorID);

//        try (PreparedStatement stmt = connection.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                newsList.add(rs.getString("Title"));
//            }
//        }
		return newsList;
	}

	public static List<News> searchNews(String keyword) throws SQLException {
		String sql = "SELECT * FROM NEWS WHERE Title like ?";
		List<News> newsList = XJdbc.getResultList(News.class, sql, "%" + keyword + "%");
		sql = "SELECT * FROM NEWS WHERE Content like ?";
		newsList.addAll(XJdbc.getResultList(News.class, sql, "%" + keyword + "%"));
		sql = "SELECT NEWS.* FROM NEWS JOIN USERS ON NEWS.Author = USERS.Id WHERE USERS.Fullname like ?";
		newsList.addAll(XJdbc.getResultList(News.class, sql, "%" + keyword + "%"));
		sql = "SELECT NEWS.* FROM NEWS JOIN CATEGORIES ON NEWS.CategoryId = CATEGORIES.Id WHERE CATEGORIES.Name like ?";
		newsList.addAll(XJdbc.getResultList(News.class, sql, "%" + keyword + "%"));
		return newsList;
	}
	
	public static List<News> searchNewsByAuthor(int authorID, String keyword) throws SQLException {
		String sql = "SELECT NEWS.* FROM NEWS JOIN USERS ON NEWS.Author = USERS.Id WHERE USERS.Id = ? AND Title like ?";
		List<News> newsList = XJdbc.getResultList(News.class, sql, "%" + keyword + "%");
		sql = "SELECT NEWS.* FROM NEWS JOIN USERS ON NEWS.Author = USERS.Id WHERE USERS.Id = ? AND Content like ?";
		newsList.addAll(XJdbc.getResultList(News.class, sql, "%" + keyword + "%"));
		sql = "SELECT NEWS.* FROM NEWS JOIN CATEGORIES ON NEWS.CategoryId = CATEGORIES.Id WHERE USERS.Id = ? AND CATEGORIES.Name like ?";
		newsList.addAll(XJdbc.getResultList(News.class, sql, "%" + keyword + "%"));
		return newsList;
	}

	public static List<News> searchAll(String keyword) throws SQLException {
	    String sql = "SELECT DISTINCT NEWS.* " +
	                 "FROM NEWS " +
	                 "LEFT JOIN USERS ON NEWS.Author = USERS.Id " +
	                 "LEFT JOIN CATEGORIES ON NEWS.CategoryId = CATEGORIES.Id " +
	                 "WHERE NEWS.Title LIKE ? " +
	                 "OR NEWS.Content LIKE ? " +
	                 "OR USERS.Fullname LIKE ? " +
	                 "OR CATEGORIES.Name LIKE ?";

	    String searchKeyword = "%" + keyword + "%";
	    return XJdbc.getResultList(News.class, sql, searchKeyword, searchKeyword, searchKeyword, searchKeyword);
	}

	public static List<News> getNewsByCategory(String categoryName) throws SQLException {
		String sql = "SELECT NEWS.* FROM NEWS JOIN CATEGORIES ON NEWS.CategoryId = CATEGORIES.Id WHERE CATEGORIES.Name = ?";
		List<News> newsList = XJdbc.getResultList(News.class, sql, categoryName);
		return newsList;
	}

	public static List<News> getNewsByDateRange(Date startDate, Date endDate) throws SQLException {
		String sql = "SELECT * FROM NEWS WHERE PostedDate BETWEEN ? AND ?";
		List<News> newsList = XJdbc.getResultList(News.class, sql, startDate, endDate);
		return newsList;
	}
	
	public static List<News> getLatestNews() throws SQLException {
	    String sql = "SELECT TOP 5 * FROM NEWS ORDER BY PostedDate DESC";
	    List<News> newsList = XJdbc.getResultList(News.class, sql);
	    return newsList;
	}

	public static List<News> getTopNewsByViews() throws SQLException {
		String sql = "SELECT TOP 5 * FROM NEWS ORDER BY ViewCount DESC";
		List<News> newsList = XJdbc.getResultList(News.class, sql);
		return newsList;
	}

	public static List<News> getRecentlyViewedNewsByUser(int userId, int limit) throws SQLException {
	    String sql = "SELECT TOP 5 N.* FROM NEWS N " +
	                 "JOIN USER_VIEWS UV ON N.Id = UV.NewsId " +
	                 "WHERE UV.UserId = ? " +
	                 "ORDER BY UV.ViewedDate DESC";
	    return XJdbc.getResultList(News.class, sql, limit, userId);
	}

	public static List<News> getRelatedNews(int categoryId, int newsId) throws SQLException {
		String sql = "SELECT TOP 5 * FROM News WHERE categoryId = ? AND id <> ?";
		return XJdbc.getResultList(News.class, sql, categoryId, newsId);
	}

	public static int generateNewId() throws ClassNotFoundException, SQLException {
		String sql = "select count(*) from NEWS";
		return (int) XJdbc.getValue(sql) + 1;
	}
}
