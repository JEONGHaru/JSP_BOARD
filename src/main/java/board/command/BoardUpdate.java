package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.Bbs;
import bbs.BbsDAO;
import util.Script;

public class BoardUpdate implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String)session.getAttribute("userID");
		}
		int bbsID = 0;
		if(request.getParameter("bbsID") != null){
			bbsID = Integer.parseInt(request.getParameter("bbsID"));
		}
		
		
		Bbs bbs = new BbsDAO().getBbs(bbsID);
		
			BbsDAO bbsDAO = new BbsDAO();
			int result = bbsDAO.update(bbsID,request.getParameter("title"),request.getParameter("content"));
			if (result == -1) {
				Script.back(response, "失敗しました。");
			} else {
				Script.save(response, "修正しました。", "list");

			}
	}

}
