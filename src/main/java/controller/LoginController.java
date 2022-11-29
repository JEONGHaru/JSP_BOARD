package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userID_ = request.getParameter("userID");
		String userPassword_ = request.getParameter("userPassword");

		
		String userID = null;
		if(userID_ != null && !userID_.equals(""))
			userID = userID_;
		String userPassword = null;
		if(userPassword_ != null && !userPassword_.equals(""))
			userPassword = userPassword_;
		
		
		UserDAO userDAO = new UserDAO();
		int result = userDAO.login(userID, userPassword);
		if(result == 1){
			session.setAttribute("userID",userID);
			response.getWriter().append("<script> alert('ログインできました'); location.href='main'; </script>");
			return;
		}
		else if(result == 0){
			response.getWriter().append("<script> alert('PASSWORDが一致しません'); history.back(); </script>");
			return;
		}
		else if(result == -1){
			response.getWriter().append("<script> alert('IDが一致しません'); history.back(); </script>");
			return;
		}
		else if(result == -2){
			System.out.println("データベースERROR");
			request.getRequestDispatcher("WEB-INF/view/main.jsp").forward(request, response);
			return;
		}
		
		
		
		
			
		
	}
}
