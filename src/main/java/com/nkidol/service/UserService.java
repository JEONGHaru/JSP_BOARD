package com.nkidol.service;

import com.nkidol.domain.user.User;
import com.nkidol.domain.user.dao.UserDAO;
import com.nkidol.domain.user.dto.JoinDTO;
import com.nkidol.domain.user.dto.LoginDTO;

public class UserService {

	private UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	public int join(User user) {
		int result = userDAO.sava(user);
		return result;
	}
	
	public User login(LoginDTO dto) {
		
		return userDAO.findByUser(dto);
	}
	
	public int idCheck(String userID) {
		
		int result = userDAO.findByUserID(userID);
		
		return result;
	}
}
