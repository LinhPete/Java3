package Entity;

import java.util.Date;
import java.sql.SQLException;

import DAO.CategoryDAO;
import DAO.UserDAO;
import util.other.XDate;

public class News {
	private int id;
	private String title;
	private String content;
	private String image;
	private Date postedDate;
	private int author;
	private int viewCount;
	private int categoryId;
	private boolean home;

	public News() {
		super();
	}

	public News(int id, String title, String content, String image, Date postedDate, int author, int viewCount,
			int categoryId, boolean home) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.image = image;
		this.postedDate = postedDate;
		this.author = author;
		this.viewCount = viewCount;
		this.categoryId = categoryId;
		this.home = home;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPostedDate() {
		return XDate.toString(postedDate, XDate.VN_DATE_1);
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public boolean isHome() {
		return home;
	}

	public void setHome(boolean home) {
		this.home = home;
	}

	public String getRepId() {
		return "NW" + id;
	}
	
	public String getAuthorName() throws SQLException {
		return UserDAO.getUserById(author).getFullname();
	}
	
	public String getCategoryName() throws SQLException {
		return CategoryDAO.getCategoryById(categoryId).getName();
	}

	public Object[] toInsertData() {
		Object[] data = { title, content, image, postedDate, author, viewCount, categoryId, home };
		return data;
	}

	public Object[] toUpdateData() {
		Object[] data = { title, content, image, postedDate, author, viewCount, categoryId, home, id };
		return data;
	}
}
