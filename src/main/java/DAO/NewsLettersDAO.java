package DAO;

import java.sql.*;

public class NewsLettersDAO {
    private Connection connection;

    public NewsLettersDAO(Connection connection) {
        this.connection = connection;
    }

    public void addNewsletter(String email, boolean enabled) throws SQLException {
        String sql = "INSERT INTO NEWSLETTERS (Email, Enabled) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setBoolean(2, enabled);
            stmt.executeUpdate();
        }
    }

    public void updateNewsletter(String email, boolean enabled) throws SQLException {
        String sql = "UPDATE NEWSLETTERS SET Enabled = ? WHERE Email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setBoolean(1, enabled);
            stmt.setString(2, email);
            stmt.executeUpdate();
        }
    }

    public void deleteNewsletter(String email) throws SQLException {
        String sql = "DELETE FROM NEWSLETTERS WHERE Email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.executeUpdate();
        }
    }

    public boolean isNewsletterEnabled(String email) throws SQLException {
        String sql = "SELECT Enabled FROM NEWSLETTERS WHERE Email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean("Enabled");
                }
            }
        }
        return false;
    }
}
