package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;
import user.UserDAO;

@WebServlet("/join")
public class JoinController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/view/join.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userID = request.getParameter("userID");
		String userPsword = request.getParameter("userPsword");
		String userName = request.getParameter("userName");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		
		HttpSession session = request.getSession();
		
		UserDAO userDAO = new UserDAO();
		User user = new User(userID,userPsword,userName,userGender,userEmail);
		int result = userDAO.join(user);
		String errorMessage = null;
		if(result == -1) {
			response.getWriter().append(String
					.format("<script> alert('%sのIDは登録できません'); history.back(); </script>"
							, userID));
		}else {
			response.sendRedirect("main");
		}
	
	}
}
