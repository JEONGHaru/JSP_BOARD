package board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.Bbs;
import bbs.BbsDAO;
import user.UserDAO;

public class BoardList implements BoardCommand{

	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) {
		
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
		
		BbsDAO bbsDAO = new BbsDAO();
		UserDAO userDAO = new UserDAO();
		boolean emailCheck = userDAO.getEmailCheked(userID);
		int count = bbsDAO.getCount();
		ArrayList<Bbs> list = bbsDAO.getList(field,query,page);
		
		request.setAttribute("userID", userID);
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("emailCheck", emailCheck);
	}
}