package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;
import util.SHA256;

@WebServlet("/emailChecked")
public class EmailChecked extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		UserDAO userDAO = new UserDAO();
		String code = null;
		if(request.getParameter("code") != null && !request.getParameter("code").equals("")) {
			code = request.getParameter("code");
		}
		String userID = null;
		if(session.getAttribute("userID") != null && !session.getAttribute("userID").equals("")) {
			userID = (String) session.getAttribute("userID");
		}
		if(userID == null){
			response.getWriter().append("<script> alert('ログインしてください'); location.href='main'; </script>");
			return;
		}
		
		String userEmail = userDAO.getUserEmail(userID);
		
		boolean isRight =( new SHA256().getSHA256(userEmail).equals(code))?true:false;
		
		if(isRight) {
			userDAO.setEmailCheked(userID);
			response.getWriter().append("<script> alert('確認できました'); location.href='main'; </script>");
		}else {
			response.getWriter().append("<script> alert('有効ではないコードです'); location.href='main'; </script>");
		}
	}
}
