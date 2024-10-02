package util.other;

public enum Accounts {
	SQL_ACC("sa","kuroneko1215");
	
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
