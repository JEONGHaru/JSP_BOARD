package com.nkidol.command.album;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nkidol.domain.album.dto.ImageDTO;
import com.nkidol.service.AlbumService;
import com.nkidol.util.Script;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class AlbumUpload implements AlbumCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String URI = request.getRequestURI();
		String nation = URI.contains("/korea")?"korea":"japan";
		int year = Integer.parseInt(request.getParameter("year"));
		String gender = request.getParameter("gen");
	
		String savePath = "/images/album/"+nation+File.separator+year+File.separator+gender;
		String realPath = request.getServletContext().getRealPath(savePath);
		int maxSize = 1024 * 1024 * 50;
		File dir = new File(realPath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		MultipartRequest multi = new MultipartRequest(request, realPath,maxSize,"UTF-8",
				new DefaultFileRenamePolicy());
		String groupName = multi.getParameter("groupName");
		String debut = multi.getParameter("debut");
		String fileName = multi.getFilesystemName("image");
		String filePath = savePath+File.separator+fileName;
	    ImageDTO dto = new ImageDTO();
	    AlbumService service = new AlbumService();
	    dto.setGroupName(groupName);
	    dto.setYear(year);
	    dto.setGender(gender);
	    dto.setDebut(debut);
	    dto.setNation(nation);
	    dto.setFilePath(filePath);
	    int result = service.imageUpload(dto);
	    if(result == 1) {
	    	
	    	response.sendRedirect("/album/"+nation+"?year="+year+"&gen="+gender);
	    }
	    

		
	}

}
