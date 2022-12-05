package bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.DatabaseUtil;

public class BbsDAO {
	
	
	
	public int write(String title, String userID, String content) {
		
		String SQL = "INSERT INTO BBS(TITLE,USERID,CONTENT) VALUES(?,?,?)";
		int result = 0;
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, title);
			pstmt.setString(2, userID);
			pstmt.setString(3, content);
			
			result = pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1; //데이터 베이스 오류
		
	}
	
	public ArrayList<Bbs> getList( ){
		
		return getList("title","",1);
	}
	
	public ArrayList<Bbs> getList(int page){
		
		return getList("title","",page);
	}
	
	public ArrayList<Bbs> getList(String field,String query,int page){
		
		String SQL = "SELECT * FROM BBS WHERE " +field+ " LIKE ? AND AVAILABLE = 1 ORDER BY REGDATE DESC LIMIT ?,10;";
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "%"+query+"%");
			pstmt.setInt(2, (page - 1) * 10);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setId(rs.getInt(1));
				bbs.setTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setRegDate(rs.getString(4));
				bbs.setContent(rs.getString(5));
				bbs.setAvailable(rs.getInt(6));
				list.add(bbs);
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
		String SQL = "SELECT COUNT(ID) AS COUNT FROM BBS WHERE AVAILABLE =1 ORDER BY REGDATE DESC";
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
	
	
	
	public Bbs getBbs(int id) {
		String SQL = "SELECT * FROM BBS WHERE ID = ?";
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt =conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setId(rs.getInt(1));
				bbs.setTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setRegDate(rs.getString(4));
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
		
		String SQL = "UPDATE BBS SET TITLE =?, CONTENT= ? WHERE ID = ?";
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
		String SQL = "UPDATE BBS SET AVAILABLE = 0 WHERE id = ?";
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
