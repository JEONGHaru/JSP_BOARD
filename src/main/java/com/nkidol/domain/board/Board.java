package com.nkidol.domain.board;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Board {

	private int id;
	private String title;
	private String userID;
	private Date regDate;
	private String content;
	private int available;
	
	
	
}
