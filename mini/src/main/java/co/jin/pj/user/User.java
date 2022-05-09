package co.jin.pj.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.jin.pj.main.Menu;
import co.jin.pj.user.service.UserService;
import co.jin.pj.user.service.UserVO;
import co.jin.pj.user.serviceImpl.UserServiceImpl;

public class User {
	static Scanner scn = new Scanner(System.in);
	static UserService service = new UserServiceImpl();
	static List<UserVO> list = new ArrayList<UserVO>();

	public static void login() {
		UserVO vo = new UserVO();
		System.out.println("============ 로 그 인 ============");
		System.out.print("ID >>");
		vo.setUserId(scn.nextLine());
		System.out.print("비밀번호 >>");
		vo.setUserPassword(scn.nextLine());

		int result = service.loginUser(vo);

		if (result == 1) {
			Menu.loginMenu();
		}
	}

	public static void userInsert() { /// 가입
		UserVO vo = new UserVO();
		System.out.println("============ 회 원 가 입 ============");
		System.out.print("ID >>");
		vo.setUserId(scn.nextLine());
//		String userId = scn.nextLine();
		System.out.print("비밀번호 >>");
		String userPassword = scn.nextLine();
		System.out.print("비밀번호 확인");
		while (true) {
			String userPassword2 = scn.nextLine();
			if (userPassword.equals(userPassword2)) {
				vo.setUserPassword(userPassword);
				break;
			} else {
				System.out.println("비밀번호가 불일치합니다. 다시 정확히 입력해주세요");
			}
		}
		System.out.print("연락처 >>");
		vo.setUserPhone(scn.nextLine());
//		String userPhone = scn.nextLine();
		System.out.print("주소 >>");
		vo.setUserAddress(scn.nextLine());
//		String userAddress = scn.nextLine();
		System.out.print("닉네임 >>");
		vo.setUserNickname(scn.nextLine());
//		String userNickname = scn.nextLine();
		vo.setBlackList("N");

		service.insertUser(vo);

	}


	public void userDelete() { /// 회원 탈퇴
		System.out.println("ID >>");
		String userId = scn.nextLine();
		System.out.println("비밀번호 >>");
		String userPassword = scn.nextLine();
	}

	public static void blackList() {
		list = service.blackListSelect();
		for(UserVO vo : list) {
			System.out.printf("블랙리스트 ID : %s  블랙리스트 닉네임 : %s \n",vo.getUserId(),vo.getUserNickname());
		}
	}
	
	public static void selectUser() {
		UserVO vo = new UserVO();
		System.out.println("ID >>");
		vo.setUserId(scn.nextLine());
		vo = service.selectUser(vo);
		
		System.out.printf("ID : %s  연락처 : %s  주소 : %s  닉네임 : %s \n",vo.getUserId(),vo.getUserPhone(),vo.getUserAddress(),vo.getUserNickname());
	}
	
	public static void userUpdate() { /// 회원정보 수정
		UserVO vo = new UserVO();
		System.out.print("현재 ID >>");
		String userId = scn.nextLine();
		vo.setUserId(userId);
		System.out.println();
		System.out.print("현재 비밀번호 >>");
		String userPassword = scn.nextLine();
		vo.setUserPassword(userPassword);
		System.out.print("수정할 비밀번호 >>");
		String userPassword2 = scn.nextLine();
		vo.setUserPassword(userPassword2);
		System.out.print("수정할 연락처 >>");
		String phone = scn.nextLine();
		vo.setUserPhone(phone);
		System.out.print("수정할 주소 >>");
		String address = scn.nextLine();
		vo.setUserAddress(address);
		System.out.print("수정할 닉네임 >>");
		vo.setUserNickname(scn.nextLine());
		
		service.updateUser(vo);
	}
	
}
