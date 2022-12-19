package com.nkidol.domain.album.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nkidol.domain.album.dto.ImageDTO;
import com.nkidol.domain.album.dto.ImageLikeDTO;
import com.nkidol.util.DatabaseUtil;

public class AlbumDAO {

	public int save(ImageDTO dto) {
		
		String SQL = "INSERT INTO ALBUMIMAGE(groupName,year,gender,debut,nation,filePath) VALUES(?,?,?,?,?,?)";
		int result = 0;
		
		Connection conn = DatabaseUtil.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, dto.getGroupName());
			pstmt.setInt(2, dto.getYear());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getDebut());
			pstmt.setString(5, dto.getNation());
			pstmt.setString(6, dto.getFilePath());
			result = pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
		
	}

	public ArrayList<ImageDTO> getList(ImageDTO iDto) {
		String SQL = "SELECT * FROM ALBUMIMAGE WHERE year = ? AND gender = ? AND nation = ? ORDER BY YEAR DESC;";
		ArrayList<ImageDTO> list = new ArrayList<ImageDTO>();
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,iDto.getYear());
			pstmt.setString(2, iDto.getGender());
			pstmt.setString(3, iDto.getNation());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ImageDTO dto = new ImageDTO();
				dto.setImageID(rs.getInt("imageID"));
				dto.setGroupName(rs.getString("groupName"));
				dto.setYear(rs.getInt("year"));
				dto.setDebut(rs.getString("debut"));
				dto.setLikeCount(rs.getInt("likeCount"));
				dto.setFilePath(rs.getString("filePath"));
				list.add(dto);
			}
			
			conn.close();
			pstmt.close();
			rs.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int delete(int imageID) {
		String SQL = "DELETE FROM ALBUMIMAGE WHERE imageID = ?";
		int result = 0;
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt =conn.prepareStatement(SQL);
			pstmt.setInt(1, imageID);
			result = pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	public int countPlus(int imageID) {
		String SQL = "UPDATE ALBUMIMAGE SET LIKECOUNT = LIKECOUNT + 1 WHERE imageID = ?";
		int result = 0;
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, imageID);
			result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	public int countCancel(int imageID) {
		String SQL = "UPDATE ALBUMIMAGE SET LIKECOUNT = LIKECOUNT - 1 WHERE imageID = ?";
		int result = 0;
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, imageID);
			result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	public int likeSave(ImageLikeDTO dto) {
		String SQL = "INSERT INTO IMAGELIKE VALUES(?,?)";
		int result = 0;
		
		Connection conn = DatabaseUtil.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,dto.getImageID());
			pstmt.setString(2, dto.getLikeUserID());
			result = pstmt.executeUpdate();
			conn.close();
			pstmt.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
		
		
	}

	public int likeDelete(ImageLikeDTO dto) {
		
		String SQL = "DELETE FROM IMAGELIKE WHERE likeImageID = ? AND likeUserID = ?";
		int result = 0;
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt =conn.prepareStatement(SQL);
			pstmt.setInt(1, dto.getImageID());
			pstmt.setString(2, dto.getLikeUserID());
			result = pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}

	public void liked(ImageDTO dto, String userID) {
		String SQL = "SELECT * FROM IMAGELIKE WHERE likeImageID =? AND likeUserID =?";
		Connection conn = DatabaseUtil.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, dto.getImageID());
			pstmt.setString(2, userID);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setLiked(false);
			}else {
				dto.setLiked(true);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


	
}
