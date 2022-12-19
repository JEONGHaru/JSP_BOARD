package com.nkidol.domain.album.dto;

import java.net.URLEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageDTO {
	private int imageID;
	private String groupName;
	private int year;
	private String gender;
	private String debut;
	private String nation;
	private int likeCount;
	private boolean liked; 
	private String filePath;

	
	
}
