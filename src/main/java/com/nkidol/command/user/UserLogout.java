package com.nkidol.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.util.Script;

public class UserLogout implements UserCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
			Script.save(response, "ログアウトしました", "/main");
		}else{
			Script.back(response, "ログインしてください");
		}
	}

}
