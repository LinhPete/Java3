package DAO;

import java.sql.*;
import java.util.List;

import Entity.Newsletters;
import util.other.DataSourceFactory;

public class NewsLettersDAO {
//    private Connection connection;
//
//    public NewsLettersDAO(Connection connection) {
//        this.connection = connection;
//    }

    public static void addNewsletter(Newsletters letter) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO NEWSLETTERS (Email, Enabled) VALUES (?, ?)";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, email);
//            stmt.setBoolean(2, enabled);
//            stmt.executeUpdate();
//        }
        DataSourceFactory.IUD(sql, letter.toInsertData());
    }

    public static void updateNewsletter(Newsletters letter) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE NEWSLETTERS SET Enabled = ? WHERE Email = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setBoolean(1, enabled);
//            stmt.setString(2, email);
//            stmt.executeUpdate();
//        }
        DataSourceFactory.IUD(sql, letter.toUpdateData());
    }

    public static void deleteNewsletter(String email) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM NEWSLETTERS WHERE Email = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, email);
//            stmt.executeUpdate();
//        }
        DataSourceFactory.IUD(sql, email);
    }

    public static boolean isNewsletterEnabled(String email) throws SQLException, ClassNotFoundException {
        String sql = "SELECT Enabled FROM NEWSLETTERS WHERE Email = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, email);
//            try (ResultSet rs = stmt.executeQuery()) {
//                if (rs.next()) {
//                    return rs.getBoolean("Enabled");
//                }
//            }
//        }
        boolean result = DataSourceFactory.getValue(sql, email)!=null;
        return result;
    }
    
    public static List<String> getEnabledEmailList(){
    	String sql = "SELECT Email FROM NEWSLETTERS WHERE Enabled = true";
    	List<String> list = DataSourceFactory.getResultList(String.class, sql);
    	return list;
    }
}
