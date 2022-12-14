package com.nkidol.service;

import com.nkidol.domain.album.dao.AlbumDAO;
import com.nkidol.domain.album.dto.ImageDTO;

public class AlbumService {

	AlbumDAO albumDAO;
	
	public AlbumService(){
		albumDAO = new AlbumDAO(); 
	}
	
	public int imageUpload(ImageDTO dot) {
		
		int result = albumDAO.save(dot);
		return result;
	}
}
