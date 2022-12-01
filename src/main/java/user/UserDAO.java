package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Result;

import util.DatabaseUtil;

public class UserDAO {
	
	public int login(String userID, String userPassword) {
		
		String SQL = "SELECT userPassword FROM USER WHERE userID=?";
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1;  //로그인 성공
				}else return 0;  //비밀번호 불일치
			}
			conn.close();
			pstmt.close();
			rs.close();
			return -1; //아이디가 없음
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return -2;  //데이터 베이스 오류
	}
	
	public int join(User user) {
		
		String SQL = "INSERT INTO USER VALUES(?,?,?,?,?,?,?,?)";
		int result = 0;
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserFirstName());
			pstmt.setString(4, user.getUserLastName());
			pstmt.setString(5, user.getUserGender());
			pstmt.setString(6, user.getUserEmail());
			pstmt.setString(7, user.getUserEmailHash());
			pstmt.setBoolean(8, user.getEmailChecked());
			result = pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return result;
	}
	
	public String getUserEmail(String userID) {
		
		String SQL = "SELECT userEmail FROM USER WHERE userID = ?";
		String result = "";
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,userID);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) result = rs.getString(1);
			
			
			conn.close();
			pstmt.close();
			rs.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return result;
}
	
	public boolean getEmailCheked(String userID) {
		
		String SQL = "SELECT emailChecked FROM USER WHERE userID = ?";
		boolean result = false;
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,userID);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) result = rs.getBoolean(1);
			conn.close();
			pstmt.close();
			rs.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return result;
	}
	public void setEmailCheked(String userID) {
		
		String SQL = "UPDATE USER SET EMAILCHECKED = true WHERE userID = ?";
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,userID);
			pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
}
}
