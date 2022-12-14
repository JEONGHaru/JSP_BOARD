package com.nkidol.domain.album.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nkidol.domain.album.dto.ImageDTO;
import com.nkidol.util.DatabaseUtil;

public class AlbumDAO {

	public int save(ImageDTO dto) {
		
		String SQL = "INSERT INTO ALBUMIMAGE(FILEPATH,GROUPNAME,YEAR) VALUES(?,?,?)";
		int result = 0;
		
		Connection conn = DatabaseUtil.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, dto.getFilePath());
			pstmt.setString(2, dto.getGroupName());
			pstmt.setString(3, dto.getYear());
			result = pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
}
