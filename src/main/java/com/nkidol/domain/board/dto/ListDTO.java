package com.nkidol.domain.board.dto;

import com.nkidol.domain.board.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ListDTO {

	private String field;
	private String query;
	private int page;
	
}
