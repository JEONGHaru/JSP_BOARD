package bbs;

public class Bbs {
	
	private int id;
	private String title;
	private String userID;
	private String regDate;
	private String content;
	private int available;
	
	public Bbs() {
	}

	public Bbs(int id, String title, String userID, String regDate, String content, int available) {
		super();
		this.id = id;
		this.title = title;
		this.userID = userID;
		this.regDate = regDate;
		this.content = content;
		this.available = available;
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

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Bbs [id=" + id + ", title=" + title + ", userID=" + userID + ", regDate=" + regDate + ", content="
				+ content + ", available=" + available + "]";
	}

	
	
	
	
	
}
