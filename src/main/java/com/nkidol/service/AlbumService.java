package com.nkidol.service;

import java.util.ArrayList;

import com.nkidol.domain.album.dao.AlbumDAO;
import com.nkidol.domain.album.dto.ImageDTO;
import com.nkidol.domain.album.dto.ImageLikeDTO;

public class AlbumService {

	AlbumDAO albumDAO;
	
	public AlbumService(){
		albumDAO = new AlbumDAO(); 
	}
	
	public int imageUpload(ImageDTO dot) {
		
		int result = albumDAO.save(dot);
		return result;
	}

	public ArrayList<ImageDTO> getAlbumImage(ImageDTO dto) {
		
		ArrayList<ImageDTO> list = albumDAO.getList(dto);
		return list;
	}

	public int deleteAlbumImage(int imageID) {
		
		int result = albumDAO.delete(imageID);
		
		return result;
	}

	public int likePlus(int imageID) {
		
		int result = albumDAO.countPlus(imageID);
		
		return result;
	}

	public int likeCancel(int imageID) {

		int result = albumDAO.countCancel(imageID);
		
		return result;
		
	}

	public int likeImageSave(ImageLikeDTO dto) {
		
		int result = albumDAO.likeSave(dto);
		
		return result;
	}

	public int likeImageDelete(ImageLikeDTO dto) {
		
		int result = albumDAO.likeDelete(dto);
		
		return result;
	}

	public void getLiked(ArrayList<ImageDTO> list, String userID) {
		
		for (ImageDTO dto : list) {
			albumDAO.liked(dto,userID);
		}
	}

	public ArrayList<ImageDTO> getImageList(String nation) {
		
		ArrayList<ImageDTO> list = albumDAO.getImage(nation);
		
		return list;
	}

	

	
}
