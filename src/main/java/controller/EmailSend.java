package controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;
import util.Nmail;
import util.SHA256;

@WebServlet("/emailSend")
public class EmailSend extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserDAO userDAO = new UserDAO();
		String userID = null;
		SHA256 sha256 = new SHA256();
		
		if(session.getAttribute("userID") != null  && !session.getAttribute("userID").equals("")) {
			userID = (String)session.getAttribute("userID");
		}
		if(userID == null) {
			response.getWriter().append("<script> alert('ログインしてください'); location.href='main'; </script>");
			return;
		}
		
		
		boolean emailChecked = userDAO.getEmailCheked(userID);
		if(emailChecked) {
			response.getWriter().append("<script> alert('既に確認せれてます'); location.href='main'; </script>");
		}
		
		String host ="http://localhost:8181/nkidol/";
		String from = "nkidol@naver.com";
		String to = userDAO.getUserEmail(userID);
		String subject = "NKIDOLサイトの会員登録の確認メールです";
		String content = "このURLをクリックして登録の確認をしてください。" +
				"<a href='" + host + "emailChecked?code=" + new SHA256().getSHA256(to)  + "'>確認する</a>";
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.naver.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		try {
			Authenticator auth = new Nmail();
			Session ses = Session.getInstance(props,auth);
			ses.setDebug(true);
			MimeMessage msg = new MimeMessage(ses);
			msg.setSubject(subject);
			Address fromAddr = new InternetAddress(from);
			msg.setFrom(fromAddr);
			Address toAddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(content,"text/html;charset=UTF-8");
			Transport.send(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("main");
	}
}
