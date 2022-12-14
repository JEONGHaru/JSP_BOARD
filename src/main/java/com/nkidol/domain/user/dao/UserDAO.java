package com.nkidol.domain.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nkidol.domain.user.User;
import com.nkidol.domain.user.dto.JoinDTO;
import com.nkidol.domain.user.dto.LoginDTO;
import com.nkidol.util.DatabaseUtil;

public class UserDAO {
	
	public User findByUser(LoginDTO dto) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT userID,userFirstName,userEmail,emailChecked,userGrade ");
		sb.append("FROM USER WHERE userID = ? AND userPassword = ?");
		
		String SQL = sb.toString();
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, dto.getUserID());
			pstmt.setString(2, dto.getUserPassword());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				User user = User.builder()
						.userID(rs.getString("userID"))
						.userFirstName(rs.getString("userFirstName"))
						.userEmail(rs.getString("userEmail"))
						.emailChecked(rs.getBoolean("emailChecked"))
						.userGrade(rs.getInt("userGrade"))
						.build();
				conn.close();
				pstmt.close();
				rs.close();
				return user;
			}
			
			return null; //아이디가 없음
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;  //데이터 베이스 오류
	}
	
	public int sava(User user) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO USER");
		sb.append("(userID,userPassword,userFirstName,userLastName,userGender,userEmail,userEmailHash) ");
		sb.append("VALUES(?,?,?,?,?,?,?)");
		
		String SQL = sb.toString();
		int result = 0;
		Connection conn = DatabaseUtil.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserFirstName());
			pstmt.setString(4, user.getUserLastName());
			pstmt.setString(5, user.getUserGender());
			pstmt.setString(6, user.getUserEmail());
			pstmt.setString(7, user.getUserEmailHash());
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

	public User getUser(String userID) {
		
		String SQL = "SELECT * FROM USER WHERE userID = ?";
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				User user = User.builder()
						.userID(rs.getString("userID"))
						.userFirstName(rs.getString("userFirstName"))
						.userEmail(rs.getString("userEmail"))
						.emailChecked(rs.getBoolean("emailChecked"))
						.userGrade(rs.getInt("userGrade"))
						.build();
				conn.close();
				pstmt.close();
				rs.close();
				return user;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;  //IDない
	}

	public String getId(User user) {
		String SQL = "SELECT userID FROM USER WHERE userFirstName = ? AND userLastName = ? AND userEmail = ? LIMIT 1";
		String userID = null;
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserFirstName());
			pstmt.setString(2, user.getUserLastName());
			pstmt.setString(3, user.getUserEmail());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())  userID = rs.getString("userID");
			
			conn.close();
			pstmt.close();
			rs.close();
			return userID;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userID;
	
	}

	
}
