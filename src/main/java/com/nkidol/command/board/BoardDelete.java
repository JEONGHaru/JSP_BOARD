package com.nkidol.command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.domain.board.Board;
import com.nkidol.domain.board.dao.BoardDAO;
import com.nkidol.domain.user.User;
import com.nkidol.util.Script;

public class BoardDelete implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User principal = (User)session.getAttribute("principal");
		if (principal == null) {
			Script.back(response, "ログインしてください");
		}else {
			int boardID = 0;
			if (request.getParameter("bbsID") != null) {
				boardID = Integer.parseInt(request.getParameter("bbsID"));
			}
			BoardDAO boardDAO = new BoardDAO();
			Board board = boardDAO.getBoard(boardID);
			
			if(board.getUserID().equals(principal.getUserID())) {
				int result = boardDAO.delete(boardID);
				if (result == -1) {
					Script.back(response, "失敗しました。");
				} else {
					Script.save(response, "削除しました。", "list");
				}
			}else {
				Script.back(response, "権限がありません");
			}
		}
	}
}
