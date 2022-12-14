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
						System.out.println(rs.getBoolean("emailChecked"));
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
	
	public int sava(JoinDTO dto) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO USER");
		sb.append("(userID,userPassword,userFirstName,userGender,userLastName,userEmail,userEmailHash) ");
		sb.append("VALUES(?,?,?,?,?,?,?)");
		
		String SQL = sb.toString();
		int result = 0;
		Connection conn = DatabaseUtil.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, dto.getUserID());
			pstmt.setString(2, dto.getUserPassword());
			pstmt.setString(3, dto.getUserFirstName());
			pstmt.setString(4, dto.getUserLastName());
			pstmt.setString(5, dto.getUserGender());
			pstmt.setString(6, dto.getUserEmail());
			pstmt.setString(7, dto.getUserEmailHash());
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

	public int findByUserID(String userID) {
		
		String SQL = "SELECT * FROM USER WHERE userID = ?";
		
		try {
			Connection conn = DatabaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) return 1;  //IDある
			
			conn.close();
			pstmt.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;  //IDない
	}
}
