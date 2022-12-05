package board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;
import util.Script;

public class BoardWriteView implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		HttpSession session = request.getSession();
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String)session.getAttribute("userID");
		}
		
		
		
		UserDAO userDAO = new UserDAO();
		boolean emailCheck = userDAO.getEmailCheked(userID);
		request.setAttribute("emailCheck", emailCheck);
	}

}
