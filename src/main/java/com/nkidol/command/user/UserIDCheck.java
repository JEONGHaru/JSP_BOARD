package com.nkidol.command.user;

import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nkidol.service.UserService;

public class UserIDCheck implements UserCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			BufferedReader br = request.getReader();
			String userID = br.readLine();
			UserService userService = new UserService();
			int result = userService.idCheck(userID);
			PrintWriter out = response.getWriter();
			if(result == 1) {
				out.print("ok");
			}else {
				out.print("no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	

	}

}
