package com.nkidol.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nkidol.domain.user.User;
import com.nkidol.service.UserService;
import com.nkidol.util.Script;

public class UserFindById implements UserCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userFirstName = request.getParameter("userFirstName");
		String userLastName = request.getParameter("userLastName");
		String userEmail = request.getParameter("userEmail");
		
		User user = new User();
		user.setUserFirstName(userFirstName);
		user.setUserLastName(userLastName);
		user.setUserEmail(userEmail);
		
		UserService service = new UserService();
		String userID = service.getUserId(user);
		if(userID == null) {
			Script.back(response, "一致する会員はございません");
		}else {
			Script.save(response,String.format("IDは%sです",userID ) ,"/main");
		}
	}

}
