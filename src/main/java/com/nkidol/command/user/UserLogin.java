package com.nkidol.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.domain.user.User;
import com.nkidol.domain.user.dto.LoginDTO;
import com.nkidol.service.UserService;
import com.nkidol.util.Script;

public class UserLogin implements UserCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		LoginDTO loginDTO = new LoginDTO(userID, userPassword);
		UserService userService = new UserService();
		User userEntity = userService.login(loginDTO);
		
		if (userEntity != null) {
			HttpSession session = request.getSession();
			session.setAttribute("isEmailCheck", userEntity.isEmailChecked());
			session.setAttribute("principal", userEntity);
			Script.save(response, "ログインしました。", "/main");
		}else {
			Script.back(response, "IDまたはPasswordが異なります");
		}

	}
}
