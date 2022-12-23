package com.nkidol.command.album;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.domain.user.User;
import com.nkidol.service.AlbumService;
import com.nkidol.util.Script;

public class AlbumDelete implements AlbumCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();		
		String URI = request.getRequestURI();
		String nation = URI.contains("/korea")?"korea":"japan";
		int year = Integer.parseInt(request.getParameter("year"));
		String gender = request.getParameter("gen");
		if ((User) session.getAttribute("principal") != null) {
			User principal = (User) session.getAttribute("principal");
			if (principal.getUserGrade() != 9) {
				Script.back(response, "管理者以外はできません");
			} else {
				
				int imageID = Integer.parseInt(request.getParameter("imageID"));
				String filePath = request.getParameter("filePath");
				String realPath = request.getServletContext().getRealPath(filePath);
				File deleteFile = new File(realPath);
				AlbumService service = new AlbumService();
				int result = service.deleteAlbumImage(imageID);
				if (result == 1) {
					deleteFile.delete();
					response.sendRedirect("/album/"+nation+"?year="+year+"&gen="+gender);
				} else {

					Script.back(response, "失敗");
				}
			}
		}else {
			Script.back(response, "ログインしてください");
		}

	}

}
