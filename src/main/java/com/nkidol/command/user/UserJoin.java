package com.nkidol.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.domain.user.User;
import com.nkidol.service.UserService;
import com.nkidol.util.SHA256;
import com.nkidol.util.Script;

public class UserJoin implements UserCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		String userFirstName = request.getParameter("userFirstName");
		String userLastName = request.getParameter("userLastName");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		String userEmailHash = SHA256.getSHA256(userEmail);
		
		if(!userID.matches("^[0-9a-zA-Z]*$")) {
			Script.back(response, "IDは英語と数字だけを入力してください");
		}else if(!userID.substring(0, 1).matches("^[a-zA-Z]")) {
			Script.back(response, "英語で始まるIDを入力してください");
		}else if(!userPassword.matches("^[0-9a-zA-Z]*$")) {
			Script.back(response, "Passwordは英語と数字だけを入力してください");
		}else if(!userPassword.matches(".*[0-9].*")||!userPassword.matches(".*[a-zA-Z].*")) {
			Script.back(response, "Passwordは英語と数字の組み合わせで入力してください");
		}else {
		UserService userService = new UserService();
		
		User user = new User();
		user.setUserID(userID);
		user.setUserPassword(SHA256.getSHA256(userPassword));
		user.setUserFirstName(userFirstName);
		user.setUserLastName(userLastName);
		user.setUserGender(userGender);
		user.setUserEmail(userEmail);
		user.setUserEmailHash(userEmailHash);
		System.out.println(user);
		int result = userService.join(user);
		if(result == 0) {
			Script.back(response, "そのIDは利用できません");
			
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("principal", user);
			Script.save(response, "会員登録ありがとうございます", "/main");
		}
		}
	}

}
