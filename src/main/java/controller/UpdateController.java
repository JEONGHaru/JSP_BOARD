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

@WebServlet("/update")
public class UpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
		}
		response.setContentType("text/html; charset=UTF-8");
		if(userID == null){
			response.getWriter().append("<script> alert('ログインしてください'); location.href='main'; </script>");
			return;
		}
		int bbsID = 0;
		if(request.getParameter("bbsID") != null){
			bbsID = Integer.parseInt(request.getParameter("bbsID"));
		}
		if(bbsID == 0 ){
			response.getWriter().append("<script> alert('存在してない投稿です'); history.back(); </script>");
			return;
		}
		
		Bbs bbs = new BbsDAO().getBbs(bbsID);
		if(!userID.equals(bbs.getUserID())){
			response.getWriter().append("<script> alert('権限がないです'); history.back(); </script>");
			return;
		}
		request.setAttribute("bbs",bbs);
		request.getRequestDispatcher("WEB-INF/view/update.jsp").forward(request, response);
		
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String)session.getAttribute("userID");
		}
		if(userID == null){
			response.getWriter().append("<script> alert('ログインしてください'); location.href='login'; </script>");
			return;
		}
		int bbsID = 0;
		if(request.getParameter("bbsID") != null){
			bbsID = Integer.parseInt(request.getParameter("bbsID"));
		}
		if(bbsID == 0 ){
			response.getWriter().append("<script> alert('存在してない投稿です'); history.back(); </script>");
			return;
		}
		
		Bbs bbs = new BbsDAO().getBbs(bbsID);
		if(!userID.equals(bbs.getUserID())){
			response.getWriter().append("<script> alert('権限がないです'); history.back(); </script>");
			return;
			
		}else{
			BbsDAO bbsDAO = new BbsDAO();
			int result = bbsDAO.update(bbsID,request.getParameter("title"),request.getParameter("content"));
			if(result == -1){
				response.getWriter().append("<script> alert('修正に失敗しました'); history.back(); </script>");
				return;
				}
				else{
					response.getWriter().append("<script> alert('修正しました'); location.href='board'; </script>");
					
				}
			}
			
		
		}
	}

