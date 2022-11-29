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
		}
		
		return -2;  //데이터 베이스 오류
	}
	
	public int join(User user) {
		
		String SQL = "INSERT INTO USER VALUES(?,?,?,?,?,?)";
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
