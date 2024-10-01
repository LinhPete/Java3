package util.other;

public enum Accounts {
	SQL_ACC("sa","123456789");
	
	private final String username;
	private final String password;

	Accounts(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
