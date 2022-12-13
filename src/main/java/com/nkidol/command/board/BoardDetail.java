package com.nkidol.command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.domain.board.Board;
import com.nkidol.domain.board.dao.BoardDAO;
import com.nkidol.domain.user.User;
import com.nkidol.util.Script;

public class BoardDetail implements BoardCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User principal = (User)session.getAttribute("principal");
		if(principal ==null){
			Script.back(response, "ログインしてください");
		}
		int bbsID = Integer.parseInt(request.getParameter("bbsID"));
	
		
		BoardDAO bbsDAO = new BoardDAO();
		Board board = bbsDAO.getBoard(bbsID);
		
		request.setAttribute("board", board);
		
	}

}
