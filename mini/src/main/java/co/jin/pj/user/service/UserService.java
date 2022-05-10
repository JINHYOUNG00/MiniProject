package co.jin.pj.user.service;

import java.util.List;



public interface UserService {
	
	List<UserVO> allListSelect();
	List<UserVO> blackListSelect(); // 전체 블랙리스트 명단
	UserVO selectUser(UserVO user);  // 회원정보 조회
	UserVO selectUser2(UserVO user);  // 회원정보 조회11
	int insertUser(UserVO user); //회원가입
	int updateUser(UserVO user); //한명 갱신
	int deleteUser(UserVO user); //한명 삭제
	int loginUser(UserVO user); // 로그인
	

}
