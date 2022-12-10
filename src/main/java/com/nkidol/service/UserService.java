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
	
	public int join(JoinDTO dto) {
		int result = userDAO.sava(dto);
		return result;
	}
	
	public int login(LoginDTO dto) {
		
		int result = userDAO.findByUser(dto);
		return result;
	}
}
