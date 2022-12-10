package com.nkidol.command.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nkidol.domain.board.Board;
import com.nkidol.domain.board.dao.BoardDAO;
import com.nkidol.domain.board.dto.ListDTO;
import com.nkidol.service.BoardSevice;

public class BoardList implements BoardCommand{

	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) {
		
		String field = "title";
		if(request.getParameter("field") != null && !request.getParameter("field").equals("") ){
			field = request.getParameter("field");
		}
		
		String query = "";
		if(request.getParameter("query") != null && !request.getParameter("query").equals("") ){
			query = request.getParameter("query");
		}
		
		int page = 1;
		if(request.getParameter("p") != null && !request.getParameter("p").equals("")) {
			page = Integer.parseInt(request.getParameter("p"));
		}
		
		BoardSevice boardSevice = new BoardSevice();
		ListDTO listDTO = new ListDTO(field,query,page);
		int count = boardSevice.BoardCount();
		ArrayList<Board> list = boardSevice.BoardList(listDTO);
		System.out.println(list);
		request.setAttribute("list", list);
		request.setAttribute("count", count);
	}
}
