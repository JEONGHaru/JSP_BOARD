package com.nkidol.command.album;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nkidol.domain.album.dto.ImageDTO;

public class AlbumView implements AlbumCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String URI = request.getRequestURI();
		String years = URI.replaceAll("[^0-9]","");
		String imagePath = "/images"+URI;
		String realPath = request.getServletContext().getRealPath(imagePath);
		
		File file = new File(realPath);
		String[] images = file.list(); 
		String groupName;
		String year;
		ArrayList<ImageDTO> list = new ArrayList<>();
		ImageDTO dto = new ImageDTO();
		for (String image : images) {
			if(!image.contains(".DS_Store")) {
			groupName = image.replaceAll(".+-", "");
			year = image.replaceAll("-.+","");
			dto = new ImageDTO(imagePath+"/"+image,groupName,year);
			list.add(dto);
			}
		}
		
		request.setAttribute("list", list);
		request.setAttribute("years", years);
		
	
	}

}
