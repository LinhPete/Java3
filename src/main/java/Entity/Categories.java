package Entity;

public class Categories {
	private int id;
	private String name;

	public Categories() {
		super();
	}

	public Categories(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRepId() {
		return "CT" + id;
	}

	public Object[] toInsertData() {
		Object[] data = { name };
		return data;
	}

	public Object[] toUpdateData() {
		Object[] data = { name, id };
		return data;
	}
}
