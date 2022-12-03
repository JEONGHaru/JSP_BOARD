package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.Bbs;
import bbs.BbsDAO;
import user.UserDAO;


@WebServlet("/detail")
public class DetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
		}
		int bbsID = Integer.parseInt(request.getParameter("bbsID"));
	
		
		BbsDAO bbsDAO = new BbsDAO();
		Bbs bbs = bbsDAO.getBbs(bbsID);
		
		UserDAO userDAO = new UserDAO();
		boolean emailCheck = userDAO.getEmailCheked(userID);
		
		request.setAttribute("userID", userID);
		request.setAttribute("bbs", bbs);
		request.setAttribute("emailCheck", emailCheck);
		
		request.getRequestDispatcher("/WEB-INF/view/detail.jsp").forward(request, response);
	}

}
