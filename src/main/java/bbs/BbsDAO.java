package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BbsDAO {

	private Connection conn;
	private ResultSet rs;
	
	public BbsDAO() {
		
		String dbURL = "jdbc:mysql://localhost:3306/BBS";
		String dbID = "jky";
		String dbPassword = "1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getDate() {
		
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "";
	}
	
	
	
	public int getNext() {
		
		String SQL = "SELECT ID FROM BBS ORDER BY ID DESC";
		
		try {
			PreparedStatement pstmt =conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; //첫번째 게시물인 경우
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1; //데이터 베이스 오류
		
	}
	
	public int write(String title, String userID, String content) {
		
		String SQL = "INSERT INTO BBS VALUES(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt =conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, title);
			pstmt.setString(3, userID);
			pstmt.setString(4, getDate());
			pstmt.setString(5, content);
			pstmt.setInt(6, 1);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1; //데이터 베이스 오류
		
	}
	
	public ArrayList<Bbs> getList(int page){
		
		String SQL = "SELECT * FROM BBS WHERE AVAILABLE = 1 ORDER BY REGDATE DESC LIMIT ?,10;";
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, (page - 1) * 10);
			rs = pstmt.executeQuery();
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int getCount() {
		String SQL = "SELECT COUNT(ID) AS COUNT FROM BBS WHERE AVAILABLE =1 ORDER BY REGDATE DESC";
		int count = 0;
		
		try {
			Statement pstmt = conn.createStatement();
			rs = pstmt.executeQuery(SQL);
			if(rs.next())
				count = rs.getInt("COUNT");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public boolean nextPage(int pageNumber) {
		String SQL = "SELECT * FROM BBS WHERE ID < ? AND AVAILABLE = 1 ORDER BY ID DESC LIMIT 10";
		
		try {
			PreparedStatement pstmt =conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			if(rs.next()) return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public Bbs getBbs(int id) {
		String SQL = "SELECT * FROM BBS WHERE ID = ?";
		
		try {
			PreparedStatement pstmt =conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setId(rs.getInt(1));
				bbs.setTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setRegDate(rs.getString(4));
				bbs.setContent(rs.getString(5));
				bbs.setAvailable(rs.getInt(6));
				return bbs;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(int id, String title, String content) {
		
		String SQL = "UPDATE BBS SET TITLE =?, CONTENT= ? WHERE ID = ?";
		
		try {
			PreparedStatement pstmt =conn.prepareStatement(SQL);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, id);
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1; //데이터 베이스 오류
	}
	
	public int delete(int id) {
		String SQL = "UPDATE BBS SET AVAILABLE = 0 WHERE id = ?";
		
		try {
			PreparedStatement pstmt =conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1; //데이터 베이스 오류
		
	}
}
