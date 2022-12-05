package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;

@WebServlet("/main")
public class MainController extends HttpServlet{
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userID = null;
		if(session.getAttribute("userID") != null  && !session.getAttribute("userID").equals("")){
			userID = (String) session.getAttribute("userID");
		}
		
		UserDAO userDAO = new UserDAO();
		boolean emailCheck = userDAO.getEmailCheked(userID);
		
		request.setAttribute("userID", userID);
		request.setAttribute("emailCheck", emailCheck);
		request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);
	}
	
}
