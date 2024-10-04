package util.encrypt;

public class PasswordUtil {
	// Mã hóa mật khẩu với SHA-256 (hash + salt)
    public static String hashPassword(String password) {
        return SHA256.hashPassword(password);
    }

    // Kiểm tra mật khẩu đã nhập với mật khẩu trong DB
    public static boolean checkPassword(String inputPassword, String storedHashedPassword) {
        byte[] salt = SHA256.getSalt(storedHashedPassword);
        String hashedInputPassword = SHA256.hashPassword(inputPassword, salt);
        return storedHashedPassword.equals(hashedInputPassword);
    }
}
