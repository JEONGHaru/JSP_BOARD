package user;

public class User {

	private String userID;
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private String userGender;
	private String userEmail;
	private String userEmailHash;
	private boolean emailChecked;
	
	
	public User() {
	
	}


	public User(String userID, String userPassword, String userFirstName, String userLastName, String userGender,
			String userEmail, String userEmailHash, boolean emailChecked) {
		super();
		this.userID = userID;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userEmailHash = userEmailHash;
		this.emailChecked = emailChecked;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public String getUserGender() {
		return userGender;
	}


	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserEmailHash() {
		return userEmailHash;
	}


	public void setUserEmailHash(String userEmailHash) {
		this.userEmailHash = userEmailHash;
	}


	public boolean getEmailChecked() {
		return emailChecked;
	}


	public void setEmailChecked(boolean emailChecked) {
		this.emailChecked = emailChecked;
	}


	@Override
	public String toString() {
		return "User [userID=" + userID + ", userPassword=" + userPassword + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", userGender=" + userGender + ", userEmail=" + userEmail
				+ ", userEmailHash=" + userEmailHash + ", emailChecked=" + emailChecked + "]";
	}
	
	
}
