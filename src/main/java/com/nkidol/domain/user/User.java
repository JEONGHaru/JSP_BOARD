package com.nkidol.domain.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

	private String userID;
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private String userGender;
	private String userEmail;
	private String userEmailHash;
	private boolean emailChecked;
	private int userGrade;
}
