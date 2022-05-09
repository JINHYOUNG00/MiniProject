package co.jin.pj.user.service;

import java.util.List;



public interface UserService {
	
	int insertUser(UserVO user); //회원가입
	int updateUser(UserVO user); //한명 갱신
	int deleteUser(UserVO user); //한명 삭제
	int loginUser(UserVO user); // 로그인

}
