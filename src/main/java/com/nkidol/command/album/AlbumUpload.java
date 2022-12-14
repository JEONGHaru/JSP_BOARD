package com.nkidol.command.album;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nkidol.domain.album.dto.ImageDTO;
import com.nkidol.service.AlbumService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class AlbumUpload implements AlbumCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String URI = request.getRequestURI().replace("/upload","");
		System.out.println("URI : " + URI);
		String imagePath = "/images"+URI;
		System.out.println("imagePath : " + imagePath);
		String realPath = request.getServletContext().getRealPath(imagePath);
		System.out.println("realPath : " + realPath);
		int maxSize = 1024*1024*50;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, realPath,maxSize,"UTF-8",
					new DefaultFileRenamePolicy());
			String imageName = multi.getFilesystemName("image");
			System.out.println(imageName);
			ImageDTO dto = new ImageDTO();
			AlbumService albumservice = new AlbumService();
			dto.setFilePath(imagePath+File.separator + imageName);
			dto.setGroupName(imageName.replaceAll(".+-", "").replaceAll("\\.\\w+", ""));
			dto.setYear(imageName.replaceAll("-.+",""));
			int result = albumservice.imageUpload(dto);
			if(result != 1) {
				System.out.println("データエラー");
			}else {
				response.sendRedirect(URI);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
