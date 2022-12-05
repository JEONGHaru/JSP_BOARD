package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.Bbs;
import bbs.BbsDAO;
import user.UserDAO;

public class BoardDetail implements BoardCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
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
		
	}

}
