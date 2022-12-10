package com.nkidol.command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.domain.board.Board;
import com.nkidol.domain.board.dao.BoardDAO;
import com.nkidol.domain.user.dao.UserDAO;
import com.nkidol.util.Script;

public class BoardUpdateView implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			Script.back(response, "ログインしてください");
		}else {
			
		int bbsID = 0;
		if(request.getParameter("bbsID") != null){
			bbsID = Integer.parseInt(request.getParameter("bbsID"));
		}
		Board board = new BoardDAO().getBoard(bbsID);
		
		request.setAttribute("board",board);
		request.setAttribute("bbsID", bbsID);
		}
	}

}
