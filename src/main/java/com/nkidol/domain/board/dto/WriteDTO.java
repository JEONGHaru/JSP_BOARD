package com.nkidol.domain.board.dto;

public class WriteDTO {

	private String title;
	private String userID;
	private String content;
	
	public WriteDTO(String title, String userID, String content) {
		super();
		this.title = title;
		this.userID = userID;
		this.content = content;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}