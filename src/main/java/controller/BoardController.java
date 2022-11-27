package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.Bbs;
import bbs.BbsDAO;

@WebServlet("/board")
public class BoardController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		String userID = null;
		if(session.getAttribute("userID") != null && session.getAttribute("userID").equals("") ){
			userID = (String) session.getAttribute("userID");
		}
		
		int page = 1;
		if(request.getParameter("p") != null && !request.getParameter("p").equals("")) {
			page = Integer.parseInt(request.getParameter("p"));
		}
		
		BbsDAO bbsDAO = new BbsDAO();
		ArrayList<Bbs> list = bbsDAO.getList(page);
		int count =bbsDAO.getCount();
		
		request.setAttribute("userID", userID);
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/board.jsp").forward(request, response);
	}
}
