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
import util.SHA256;

@WebServlet("/join")
public class JoinController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/view/join.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		String userFirstName = request.getParameter("userFirstName");
		String userLastName = request.getParameter("userLastName");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		String userEmailHash = SHA256.getSHA256(userEmail);
		boolean emailCheked = false;
		HttpSession session = request.getSession();
		
		response.setContentType("text/html; charset=UTF-8");
		if(!userID.matches("^[0-9a-zA-Z]*$")) {
			response.getWriter().append("<script> alert('IDは英語と数字だけを入力してください'); history.back(); </script>");
		}else if(!userID.substring(0, 1).matches("^[a-zA-Z]")) {
			response.getWriter().append("<script> alert('英語で始まるIDを入力してください'); history.back(); </script>");
		}else if(!userPassword.matches("^[0-9a-zA-Z]*$")) {
			response.getWriter().append("<script> alert('Passwordは英語と数字だけを入力してください'); history.back(); </script>");
		}else if(!userPassword.matches(".*[0-9].*")||!userPassword.matches(".*[a-zA-Z].*")) {
			response.getWriter().append("<script> alert('Passwordは英語と数字の組み合わせで入力してください'); history.back(); </script>");
		}else {
		UserDAO userDAO = new UserDAO();
		User user = new User(userID,userPassword,userFirstName,userLastName,userGender,userEmail,userEmailHash,emailCheked);
		int result = userDAO.join(user);
		if(result == 0) {
			response.getWriter().append(String
					.format("<script> alert('%sのIDは登録できません'); history.back(); </script>"
							, userID));
		}else {
			session.setAttribute("userID", userID);
			response.getWriter().append("<script> alert('会員登録ありがとうございます'); location.href='main'; </script>");
		}
		}
	}
}
