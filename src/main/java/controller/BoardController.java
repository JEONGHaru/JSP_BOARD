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
		
		String field = "title";
		if(request.getParameter("field") != null && !request.getParameter("field").equals("") ){
			field = request.getParameter("field");
		}
		
		String query = "";
		if(request.getParameter("query") != null && !request.getParameter("query").equals("") ){
			query = request.getParameter("query");
		}
		
		String userID = null;
		if(session.getAttribute("userID") != null && !session.getAttribute("userID").equals("") ){
			userID = (String) session.getAttribute("userID");
		}
		
		int page = 1;
		if(request.getParameter("p") != null && !request.getParameter("p").equals("")) {
			page = Integer.parseInt(request.getParameter("p"));
		}
		
		System.out.printf("%s , %s%n",field,query);
		BbsDAO bbsDAO = new BbsDAO();
		int count = bbsDAO.getCount();
		ArrayList<Bbs> list = bbsDAO.getList(field,query,page);
		request.setAttribute("userID", userID);
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/board.jsp").forward(request, response);
	}
}
