package com.nkidol.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.command.board.BoardCommand;
import com.nkidol.command.board.BoardDelete;
import com.nkidol.command.board.BoardDetail;
import com.nkidol.command.board.BoardList;
import com.nkidol.command.board.BoardUpdate;
import com.nkidol.command.board.BoardUpdateView;
import com.nkidol.command.board.BoardWrite;
import com.nkidol.command.board.BoardWriteView;
import com.nkidol.util.Script;



@WebServlet("/board/*")
public class BoardController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String URL = request.getRequestURI();
		String cmd = URL.replace("/board", "");
		BoardCommand command = null;
		
		if(cmd.equals("/list")) {
			command = new BoardList();
			command.execute(request, response);
			request.getRequestDispatcher("/WEB-INF/view/board/list.jsp").forward(request, response);
		}else if(cmd.equals("/detail")) {
			command = new BoardDetail();
			command.execute(request, response);
			request.getRequestDispatcher("/WEB-INF/view/board/detail.jsp").forward(request, response);
		}else if(cmd.equals("/write_view")) {
			command = new BoardWriteView();
			command.execute(request, response);
			request.getRequestDispatcher("/WEB-INF/view/board/write_view.jsp").forward(request, response);
		}else if(cmd.equals("/write")) {
			try {
				command = new BoardWrite();
				command.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("/update_view")) {
			command = new BoardUpdateView();
			command.execute(request, response);
			request.getRequestDispatcher("/WEB-INF/view/board/update_view.jsp").forward(request, response);
		}else if(cmd.equals("/update")) {
			command = new BoardUpdate();
			command.execute(request, response);
		}else if(cmd.equals("/delete")) {
			command = new BoardDelete();
			command.execute(request, response);
		}
	
	}
}
