package com.nkidol.command.album;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nkidol.domain.album.dto.ImageLikeDTO;
import com.nkidol.service.AlbumService;

public class AlbumLikeAdd implements AlbumCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int imageID = Integer.parseInt(request.getParameter("imageID"));
		String userID = request.getParameter("userID");
		AlbumService service = new AlbumService();
		ImageLikeDTO dto = new ImageLikeDTO();
		dto.setImageID(imageID);
		dto.setLikeUserID(userID);
		int result = service.likeImageSave(dto);
		try {
			if(result == 1) {
				service.likePlus(imageID);
			}else {
				PrintWriter out = response.getWriter();
				out.print(-1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
