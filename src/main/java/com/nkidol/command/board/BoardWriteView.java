package com.nkidol.command.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.domain.user.dao.UserDAO;
import com.nkidol.util.Script;

public class BoardWriteView implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		String userID = null;
		if(session.getAttribute("principal") != null){
			userID = (String)session.getAttribute("principal");
		}else {
			Script.back(response, "ログインしてください");
		}
	}

}
