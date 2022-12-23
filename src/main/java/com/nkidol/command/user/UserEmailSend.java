package com.nkidol.command.user;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.domain.user.User;
import com.nkidol.domain.user.dao.UserDAO;
import com.nkidol.util.App;
import com.nkidol.util.Nmail;
import com.nkidol.util.SHA256;
import com.nkidol.util.Script;
import com.nkidol.util.Email.Email;

public class UserEmailSend implements UserCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserDAO userDAO = new UserDAO();
		User user = new User();
		if (session.getAttribute("principal") != null) {
			user = (User) session.getAttribute("principal");
			String userEmail = user.getUserEmail();
			String userID = user.getUserID();
			boolean emailChecked = userDAO.getEmailCheked(userID);
			if (emailChecked) {
				Script.save(response, "既に確認されてます。", "/main");
			} else {
				String host = App.getSiteHostUrl();
				String subject = "["+ App.getSiteName()+"] サイトの会員登録の確認メールです";
				String content = "このURLをクリックして登録の確認をしてください。" + "<a href='" + host + "/user/emailChecked?code="
						+ SHA256.getSHA256(userEmail) + "'>確認する</a>";
				Email.send(userEmail, subject, content);
			}
		} else {
			Script.back(response, "ログインしてください");
		}
	}

}
