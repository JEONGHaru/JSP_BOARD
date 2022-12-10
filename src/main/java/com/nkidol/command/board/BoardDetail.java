package com.nkidol.command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.domain.board.Board;
import com.nkidol.domain.board.dao.BoardDAO;
import com.nkidol.domain.user.dao.UserDAO;

public class BoardDetail implements BoardCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String userID = null;
		if(session.getAttribute("principal") != null){
			userID = (String) session.getAttribute("principal");
		}
		int bbsID = Integer.parseInt(request.getParameter("bbsID"));
	
		
		BoardDAO bbsDAO = new BoardDAO();
		Board board = bbsDAO.getBoard(bbsID);
		
		request.setAttribute("userID", userID);
		request.setAttribute("board", board);
		
	}

}
