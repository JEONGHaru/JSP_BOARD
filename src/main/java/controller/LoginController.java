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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
	}
	
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
		String idErrorMessage = null;
		String pwErrorMessage = null;
		if(result == 1){
			session.setAttribute("userID",userID);
			response.sendRedirect("main");
		}
		else if(result == 0){
			pwErrorMessage = "パスワードが一致しません。";
			request.setAttribute("pwErrorMessage", pwErrorMessage);
			request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
		}
		else if(result == -1){
			idErrorMessage = "IDが存在しません。";
			request.setAttribute("idErrorMessage", idErrorMessage);
			request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
		}
		else if(result == -2){
			System.out.println("データベースERROR");
			request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
		}
		
		
		
		
			
		
	}
}
