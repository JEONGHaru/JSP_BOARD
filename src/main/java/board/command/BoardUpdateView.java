package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.Bbs;
import bbs.BbsDAO;
import user.UserDAO;
import util.Script;

public class BoardUpdateView implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
		}
		
		int bbsID = 0;
		if(request.getParameter("bbsID") != null){
			bbsID = Integer.parseInt(request.getParameter("bbsID"));
		}
		Bbs bbs = new BbsDAO().getBbs(bbsID);
		UserDAO userDAO = new UserDAO();
		boolean emailCheck = userDAO.getEmailCheked(userID);
		request.setAttribute("emailCheck", emailCheck);
		request.setAttribute("bbs",bbs);
	}

}
