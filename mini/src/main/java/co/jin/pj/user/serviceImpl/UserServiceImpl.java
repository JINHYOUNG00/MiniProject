package co.jin.pj.user.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.jin.pj.dao.DataSource;
import co.jin.pj.user.service.UserService;
import co.jin.pj.user.service.UserVO;

public class UserServiceImpl implements UserService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn = dataSource.getConnection(); // 커넥션 연결
	private PreparedStatement psmt; // sql 명령실행
	private ResultSet rs; // select 결과를 담음

	UserVO vo = new UserVO();

	@Override
	public int loginUser(UserVO user) {
		String sql = "SELECT USER_PASSWORD FROM USERS WHERE USER_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).contentEquals(user.getUserPassword())) {
					System.out.println("로그인 성공");
					return 1;
				} else {
					System.out.println("비밀번호 불일치");
					return 0;
				}
			}
			System.out.println("아이디가 없음");
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -2;
	}

	@Override
	public int insertUser(UserVO user) { // 회원가입
		int n = 0;
		String sql = "INSERT INTO USERS VALUES(?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getUserPassword());
			psmt.setString(3, user.getUserPhone());
			psmt.setString(4, user.getUserAddress());
			psmt.setString(5, user.getUserNickname());
			psmt.setString(6, user.getBlackList());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

	@Override
	public List<UserVO> blackListSelect() {
		List<UserVO> blacklist = new ArrayList<UserVO>();

		String sql = "SELECT USER_ID, USER_NICKNAME FROM USERS WHERE BLACK_LIST = 'N'";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				vo = new UserVO();
				vo.setUserId(rs.getString("USER_ID"));
				vo.setUserNickname(rs.getString("USER_NICKNAME"));

				blacklist.add(vo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return blacklist;
	}

	@Override
	public int updateUser(UserVO user) { // 회원정보 수정
		int n = 0;
		String sql = "UPDATE USERS SET USER_PASSWORD = ?, PHONE_NUMBER = ?, ADDRESS = ?, USER_NICKNAME = ? WHERE USER_ID = ? and USER_PASSWORD = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserPassword2());
			psmt.setString(2, user.getUserPhone());
			psmt.setString(3, user.getUserAddress());
			psmt.setString(4, user.getUserNickname());
			psmt.setString(5, user.getUserId());
			psmt.setString(6, user.getUserPassword());

			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int deleteUser(UserVO user) { // 회원탈퇴
		int n = 0;
		String sql = "DELETE FROM USERS WHERE USER_PASSWORD = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserPassword());

			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserVO selectUser(UserVO user) {
		
		String sql = "SELECT USER_ID, PHONE_NUMBER, ADDRESS, USER_NICKNAME FROM USERS WHERE USER_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo = new UserVO();
				vo.setUserId(rs.getString("USER_ID"));
				vo.setUserPhone(rs.getString("PHONE_NUMBER"));
				vo.setUserAddress(rs.getString("ADDRESS"));
				vo.setUserNickname(rs.getString("USER_NICKNAME"));
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

}
