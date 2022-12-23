package com.nkidol.command.album;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.domain.album.dto.ImageDTO;
import com.nkidol.domain.user.User;
import com.nkidol.service.AlbumService;

public class AlbumView implements AlbumCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String URI = request.getRequestURI();
		int year = Integer.parseInt(request.getParameter("year"));
		
		String gender = request.getParameter("gen");
		String nation = URI.replaceAll("/album/","");
		ImageDTO dto = new ImageDTO();
		dto.setYear(year);
		dto.setGender(gender);
		dto.setNation(nation);
		AlbumService service = new AlbumService();
		ArrayList<ImageDTO> list = service.getAlbumImage(dto);
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") != null) {
			User user = (User)session.getAttribute("principal");
			String userID = user.getUserID();
			service.getLiked(list,userID);
			
		}
		
		list.sort((o1, o2) ->{
			if(o1.getDebut().equals(o2.getDebut())) return o1.getGroupName().compareTo(o2.getGroupName());
			else return o1.getDebut().compareTo(o2.getDebut());
		});
		request.setAttribute("list", list);
		request.setAttribute("years", year);
		request.setAttribute("gender", gender);
		
	
	}

}
