package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.BbsDAO;

public class BoardWrite implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userID = (String)session.getAttribute("userID");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BbsDAO bbsDAO = new BbsDAO();
		bbsDAO.write(title,userID,content);
		
	}

}
