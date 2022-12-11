package com.nkidol.command.album;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

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
		ArrayList<ImageDTO> list = new ArrayList<>();
		for (String image : images) {
			if(!image.contains(".DS_Store")) {
				ImageDTO dto = new ImageDTO();
				dto.setFilePath(imagePath+"/"+image);
				dto.setGroupName(image.replaceAll(".+-", ""));
				dto.setYear(image.replaceAll("-.+",""));
				list.add(dto);
			}
		}
		list.sort((o1, o2) ->{
			if(o1.getYear().equals(o2.getYear())) return o1.getGroupName().compareTo(o2.getGroupName());
			else return o1.getYear().compareTo(o2.getYear());
		});
		request.setAttribute("list", list);
		request.setAttribute("years", years);
		
	
	}

}
