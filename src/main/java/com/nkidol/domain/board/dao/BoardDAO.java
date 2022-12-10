package com.nkidol.domain.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nkidol.domain.board.Board;
import com.nkidol.domain.board.dto.ListDTO;
import com.nkidol.domain.board.dto.WriteDTO;
import com.nkidol.util.DatabaseUtil;

public class BoardDAO {
	
	
	
	public int write(WriteDTO dto) {
		
		String SQL = "INSERT INTO BOARD(TITLE,USERID,CONTENT) VALUES(?,?,?)";
		int result = 0;
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getUserID());
			pstmt.setString(3, dto.getContent());
			
			result = pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1; //데이터 베이스 오류
		
	}
	
	public ArrayList<Board> getList(ListDTO dto){
		
		String SQL = "SELECT * FROM BOARD WHERE " +dto.getField()+ " LIKE ? AND AVAILABLE = 1 ORDER BY REGDATE DESC LIMIT ?,10;";
		ArrayList<Board> list = new ArrayList<Board>();
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "%"+dto.getQuery()+"%");
			pstmt.setInt(2, (dto.getPage() - 1) * 10);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setId(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setUserID(rs.getString(3));
				board.setRegDate(rs.getTimestamp(4));
				board.setContent(rs.getString(5));
				board.setAvailable(rs.getInt(6));
				list.add(board);
			}
			
			conn.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int getCount() {
		String SQL = "SELECT COUNT(ID) AS COUNT FROM BOARD WHERE AVAILABLE =1 ORDER BY REGDATE DESC";
		int count = 0;
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs =  stmt.executeQuery(SQL);
			if(rs.next())
				count = rs.getInt("COUNT");
			
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	
	public Board getBoard(int id) {
		String SQL = "SELECT * FROM BOARD WHERE ID = ?";
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt =conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Board bbs = new Board();
				bbs.setId(rs.getInt(1));
				bbs.setTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setRegDate(rs.getDate(4));
				bbs.setContent(rs.getString(5));
				bbs.setAvailable(rs.getInt(6));
				
				conn.close();
				pstmt.close();
				rs.close();
				
				return bbs;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(int id, String title, String content) {
		
		String SQL = "UPDATE BOARD SET TITLE =?, CONTENT= ? WHERE ID = ?";
		int result = 0;
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, id);
			result = pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; //데이터 베이스 오류
	}
	
	public int delete(int id) {
		String SQL = "UPDATE BOARD SET AVAILABLE = 0 WHERE id = ?";
		int result = 0;
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt =conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1; //데이터 베이스 오류
		
	}
}
