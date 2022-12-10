package com.nkidol.command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.domain.board.Board;
import com.nkidol.domain.board.dao.BoardDAO;
import com.nkidol.util.Script;

public class BoardUpdate implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String)session.getAttribute("userID");
		}
		int bbsID = 0;
		if(request.getParameter("bbsID") != null){
			bbsID = Integer.parseInt(request.getParameter("bbsID"));
		}
		
			
		BoardDAO bbsDAO = new BoardDAO();
		int result = bbsDAO.update(bbsID,request.getParameter("title"),request.getParameter("content"));
		if (result == -1) {
			Script.back(response, "失敗しました。");
		} else {
			Script.save(response, "修正しました。", "list");

		}
	}

}
