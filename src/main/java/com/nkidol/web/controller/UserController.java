package com.nkidol.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nkidol.command.user.UserCommand;
import com.nkidol.command.user.UserEmailChecked;
import com.nkidol.command.user.UserEmailSend;
import com.nkidol.command.user.UserFindById;
import com.nkidol.command.user.UserFindByPw;
import com.nkidol.command.user.UserIDCheck;
import com.nkidol.command.user.UserJoin;
import com.nkidol.command.user.UserLogin;
import com.nkidol.command.user.UserLogout;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UserController() { }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String URI = request.getRequestURI();
		String cmd = URI.replaceAll("/user","");
		UserCommand command = null;
		
		if(cmd.equals("/login")) {
			command = new UserLogin();
			command.execute(request, response);
		}else if(cmd.equals("/join_view")) {
			request.getRequestDispatcher("/WEB-INF/view/user/join_view.jsp").forward(request, response);
		}else if(cmd.equals("/join")) {
			command = new UserJoin();
			command.execute(request, response);
		}else if(cmd.equals("/logout")) {
			command = new UserLogout();
			command.execute(request, response);
		}else if(cmd.equals("/emailSend")) {
			command = new UserEmailSend();
			command.execute(request, response);
			response.sendRedirect("/main");
		}else if(cmd.equals("/emailChecked")) {
			command = new UserEmailChecked();
			command.execute(request, response);
		}else if(cmd.equals("/IDCheck")) {
			command = new UserIDCheck();
			command.execute(request, response);
		}else if(cmd.equals("/findById")) {
			command = new UserFindById();
			command.execute(request, response);
		}else if(cmd.equals("/findByPw")) {
			command = new UserFindByPw();
			command.execute(request, response);
		}
	}

}
