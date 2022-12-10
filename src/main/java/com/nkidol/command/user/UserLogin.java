package com.nkidol.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.domain.user.dao.UserDAO;
import com.nkidol.domain.user.dto.LoginDTO;
import com.nkidol.service.UserService;
import com.nkidol.util.Script;

public class UserLogin implements UserCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		LoginDTO loginDTO = new LoginDTO(userID, userPassword);
		UserService userService = new UserService();
		int result = userService.login(loginDTO);
		UserDAO userDAO = new UserDAO();
		boolean isEmailCheck = userDAO.getEmailCheked(userID);

		if (result == 1) {
			session.setAttribute("isEmailCheck", isEmailCheck);
			session.setAttribute("principal", userID);
			Script.save(response, "ログインしました。", "/main");
		} else if (result == 0) {
			Script.back(response, "PASSWORDが一致しません。");
		} else if (result == -1) {
			Script.back(response, "IDが一致しません。");

		}
	}
}
