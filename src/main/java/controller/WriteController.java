package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.BbsDAO;

@WebServlet("/write")
public class WriteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String)session.getAttribute("userID");
		}else {
			request.setAttribute("userID",userID);
			return;
		}
		request.getRequestDispatcher("WEB-INF/view/write.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("userID");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BbsDAO bbsDAO = new BbsDAO();
		bbsDAO.write(title,userID,content);
		response.sendRedirect("board");
			
				
		
	}
}
