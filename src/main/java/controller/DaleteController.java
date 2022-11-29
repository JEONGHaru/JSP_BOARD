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

@WebServlet("/delete")
public class DaleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	HttpSession session = request.getSession();
	
	String userID = null;
	if(session.getAttribute("userID") != null){
		
		userID = (String)session.getAttribute("userID");
	}
	if(userID == null){
		response.getWriter().append("<script> alert('ログインしてください'); location.href='login'; </script>");
	}
	int bbsID = 0;
	if(request.getParameter("bbsID") != null){
		bbsID = Integer.parseInt(request.getParameter("bbsID"));
	}
	if(bbsID == 0 ){
		response.getWriter().append("<script> alert('もう存在してない投稿です'); location.href='board'; </script>");
	}
	
	Bbs bbs = new BbsDAO().getBbs(bbsID);
	if(!userID.equals(bbs.getUserID())){
		response.getWriter().append("<script> alert('権限がない投稿です'); location.href='board'; </script>");
		
	}else{
			BbsDAO bbsDAO = new BbsDAO();
			int result = bbsDAO.delete(bbsID);
			if(result == -1){
				response.getWriter().append("<script> alert('失敗しました'); location.href='login'; </script>");
			}
			else{
				response.getWriter().append("<script> alert('削除しました'); location.href='board'; </script>");
			}
		}
		
	

	}
}
