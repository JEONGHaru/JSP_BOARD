package com.nkidol.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.domain.user.User;
import com.nkidol.domain.user.dao.UserDAO;
import com.nkidol.util.SHA256;
import com.nkidol.util.Script;

public class UserEmailChecked implements UserCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(); 
		UserDAO userDAO = new UserDAO();
		String code = null;
		if(request.getParameter("code") != null && !request.getParameter("code").equals("")) {
			code = request.getParameter("code");
		}
		User user = new User();
		if(session.getAttribute("principal") != null && !session.getAttribute("principal").equals("")) {
			user = (User) session.getAttribute("principal");
		}
		String userEmail = userDAO.getUserEmail(user.getUserID());
		
		boolean isRight =( SHA256.getSHA256(userEmail).equals(code))?true:false;
		
		if(isRight) {
			userDAO.setEmailCheked(user.getUserID());
			boolean isEmailCheck = userDAO.getEmailCheked(user.getUserID());
			session.setAttribute("isEmailCheck", isEmailCheck);
			Script.save(response, "確認できました", "/main");
		}else {
			Script.back(response, "有効ではないコードです。");
		}
	}

}
