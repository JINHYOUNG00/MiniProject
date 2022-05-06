package co.jin.pj.user;

import java.util.Scanner;

import co.jin.pj.user.service.UserService;
import co.jin.pj.user.service.UserVO;
import co.jin.pj.user.serviceImpl.UserServiceImpl;

public class User {
	static Scanner scn = new Scanner(System.in);
	static UserService service = new UserServiceImpl();
	
	public static void userInsert() {    /// 가입
		UserVO vo = new UserVO();
		System.out.println("============ 회 원 가 입 ============");
		System.out.println("ID >>");
		vo.setUserId(scn.nextLine());
//		String userId = scn.nextLine();
		System.out.println("PASSWORD >>");
		String userPassword = scn.nextLine();
		System.out.println("CONFIRM PASSWORD");
		while (true) {
	         String userPassword2 = scn.nextLine();
	         if(userPassword.equals(userPassword2)) {
	            vo.setUserPassword(userPassword);
	            break;
	         } else {
	            System.out.println("비밀번호가 불일치합니다. 다시 정확히 입력해주세요");
	         }
	      }
		System.out.println("연락처");
		vo.setUserPhone(scn.nextLine());
//		String userPhone = scn.nextLine();
		System.out.println("주소");
		vo.setUserAddress(scn.nextLine());
//		String userAddress = scn.nextLine();
		System.out.println("닉네임");
		vo.setUserNickname(scn.nextLine());
//		String userNickname = scn.nextLine();
		
		service.insertUser(vo);
		
		
		
	}
	
	public void userUpdate() {   /// 회원정보 수정
		UserVO vo = new UserVO();
		System.out.println("ID >>");
		String userId = scn.nextLine();
		System.out.println("PASSWORD >>");
		String userPassword = scn.nextLine();
	}
	
	public void userDelete() {  /// 회원 탈퇴
		System.out.println("ID >>");
		String userId = scn.nextLine();
		System.out.println("PASSWORD >>");
		String userPassword = scn.nextLine();
	}
	
		
}
