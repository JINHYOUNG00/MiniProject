package co.jin.pj.user;

import java.util.Scanner;

import co.jin.pj.main.Menu;
import co.jin.pj.user.service.UserService;
import co.jin.pj.user.service.UserVO;
import co.jin.pj.user.serviceImpl.UserServiceImpl;

public class User {
	static Scanner scn = new Scanner(System.in);
	static UserService service = new UserServiceImpl();
	
	public static void login() {
		UserVO vo = new UserVO();
		System.out.println("============ 로 그 인 ============");
		System.out.println("ID >>");
		vo.setUserId(scn.nextLine());
		System.out.println("비밀번호 >>");
		vo.setUserPassword(scn.nextLine());
	
		int result = service.loginUser(vo);
		
		if (result == 1) {
			Menu.loginMenu();
		}
	}
	
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
		System.out.println("연락처 >>");
		vo.setUserPhone(scn.nextLine());
//		String userPhone = scn.nextLine();
		System.out.println("주소 >>");
		vo.setUserAddress(scn.nextLine());
//		String userAddress = scn.nextLine();
		System.out.println("닉네임 >>");
		vo.setUserNickname(scn.nextLine());
//		String userNickname = scn.nextLine();
		vo.setBlackList("n");
		
		service.insertUser(vo);
		
		
		
	}
	
	
	
	
	
	
	
	public static void userUpdate() {   /// 회원정보 수정
		UserVO vo = new UserVO();
		System.out.println("현재 비밀번호 >>");
		String userPassword = scn.nextLine();
		vo.setUserPassword(userPassword);
		System.out.println("수정할 비밀번호 >>");
		String userPassword2 = scn.nextLine();
		vo.setUserPassword(userPassword2);
		System.out.println("수정할 연락처 >>");
		String phone = scn.nextLine();
		vo.setUserPhone(phone);
		System.out.println("수정할 주소 >>");
		String address = scn.nextLine();
		vo.setUserAddress(address);
		System.out.println("수정할 닉네임 >>");
		vo.setUserNickname(scn.nextLine());
		
		service.updateUser(vo);
	}
	
	public void userDelete() {  /// 회원 탈퇴
		System.out.println("ID >>");
		String userId = scn.nextLine();
		System.out.println("PASSWORD >>");
		String userPassword = scn.nextLine();
	}
	
		
}
