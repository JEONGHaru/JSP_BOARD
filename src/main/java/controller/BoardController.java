package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.command.BoardCommand;
import board.command.BoardDelete;
import board.command.BoardDetail;
import board.command.BoardList;
import board.command.BoardUpdate;
import board.command.BoardUpdateView;
import board.command.BoardWrite;
import board.command.BoardWriteView;
import util.Script;



@WebServlet("/board/*")
public class BoardController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request, response);
	}
	
	private void actionDO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userID = null;
		if(session.getAttribute("userID") != null) {
			userID = (String)session.getAttribute("userID");
		}
		String viewPage = null;
		BoardCommand command = null;
		
		String URL = request.getRequestURI();
		String com = URL.replace("/board", "");
		
		
		switch(com) {
		case "/list":
			command = new BoardList();
			command.execute(request, response);
			viewPage = "list.jsp";
			break; 
		case "/detail":
			command = new BoardDetail();
			command.execute(request, response);
			viewPage = "detail.jsp";
			break;
		case "/write_view":
			if(userID == null) {
				Script.save(response, "ログインしてください", "list");
				return;
			}
			command = new BoardWriteView();
			command.execute(request, response);
			viewPage = "write_view.jsp";
			break;
		case "/write":
			if(userID == null) {
				Script.save(response, "ログインしてください", "list");
				return;
			}
			command = new BoardWrite();
			command.execute(request, response);
			response.sendRedirect("list");
			return;
		case "/delete":
			if(userID == null) {
				Script.save(response, "ログインしてください", "list");
				return;
			}
			command = new BoardDelete();
			command.execute(request, response);
			return;
		case "/update_view":
			if(userID == null) {
				Script.save(response, "ログインしてください", "list");
				return;
			}
			command = new BoardUpdateView();
			command.execute(request, response);
			viewPage = "update_view.jsp";
			break;
		case "/update":
			if(userID == null) {
				Script.save(response, "ログインしてください", "list");
				return;
			}
			command = new BoardUpdate();
			command.execute(request, response);
			return;
			
		}
		request.getRequestDispatcher("/WEB-INF/view/"+viewPage).forward(request, response);
	}
}
