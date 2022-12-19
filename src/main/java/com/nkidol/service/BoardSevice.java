package com.nkidol.service;

import java.util.ArrayList;

import com.nkidol.domain.board.Board;
import com.nkidol.domain.board.dao.BoardDAO;
import com.nkidol.domain.board.dto.ListDTO;
import com.nkidol.domain.board.dto.WriteDTO;

public class BoardSevice {

	private BoardDAO boardDAO;

	public BoardSevice() {
		boardDAO = new BoardDAO();
	}
	
	public int BoardCount() {
		
		int result = boardDAO.getCount();
		
		return result;
	}

	public ArrayList<Board> BoardList(ListDTO dto) {

		ArrayList<Board> list = boardDAO.getList(dto);
		return list;
	}
	
	public int BoardWrite(WriteDTO dto) {
		
		int result = boardDAO.write(dto);
		
		return result;
	}

//	public int BoardDetail(int id) {
//		
//		return boardDAO.getBoard(id);
//	}
	 
}
