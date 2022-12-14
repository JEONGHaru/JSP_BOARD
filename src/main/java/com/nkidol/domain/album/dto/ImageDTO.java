package com.nkidol.domain.album.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageDTO {
	private String filePath;
	private String groupName;
	private String year;
	private int likeHit;
}
