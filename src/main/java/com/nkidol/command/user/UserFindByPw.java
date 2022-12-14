package com.nkidol.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nkidol.domain.user.User;
import com.nkidol.service.UserService;
import com.nkidol.util.App;
import com.nkidol.util.Script;
import com.nkidol.util.Util;
import com.nkidol.util.Email.Email;

public class UserFindByPw implements UserCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userID = request.getParameter("userID");
		String userEmail = request.getParameter("userEmail");
		
		UserService service = new UserService();
		User user = service.getFindUser(userID);
		
		if(user == null) {
			Script.back(response, "一致する会員はございません。");
		}else if(!user.getUserEmail().equals(userEmail)) {
			Script.back(response, "登録されてるE-mailと異なります。");
		}else {
			String tempPassword = Util.getTempPassword(6);
			String subject = "["+App.getSiteName()+"]　臨時PASSWORDです";
			String content = "臨時PASSWORDは"+ tempPassword +"です。";
			Email.send(userEmail, subject, content);
			Script.save(response, String.format("%sに臨時PASSWORDを送信しました", userEmail), "/main");
		}
	}

}
