package com.nkidol.command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.domain.board.dto.WriteDTO;
import com.nkidol.service.BoardSevice;
import com.nkidol.util.Script;

public class BoardWrite implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("principal");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		if(userID != null) {
			BoardSevice boardSevice = new BoardSevice();
			WriteDTO writeDTO = new WriteDTO(title,userID,content);
			boardSevice.BoardWrite(writeDTO);
			Script.save(response, "登録しました。","list");
		}else {
			Script.back(response, "ログインしてください");
		}
	}

}
