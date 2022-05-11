package co.jin.pj.main;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.jin.pj.product.Product;
import co.jin.pj.user.User;
import co.jin.pj.user.service.UserService;
import co.jin.pj.user.service.UserVO;
import co.jin.pj.user.serviceImpl.UserServiceImpl;

public class Menu {

	private static Scanner scn = new Scanner(System.in);
	private static int menu2;
	private static String menu1;
	UserService service = new UserServiceImpl();

	public static void main() {

		boolean b = true;
		while (b) {
			try {
				System.out.println("======================================");
				System.out.println("1. 로그인 2. 회원가입 3. 블랙리스트 4. 종료");
				System.out.println("======================================");
				System.out.print("이용하실 메뉴를 입력하세요 >> ");
				menu1 = scn.nextLine();
				menu2 = Integer.parseInt(menu1) ;
				if (menu2 == 1) {
					User.login();
					System.out.println(User.loginUserId);
				} else if (menu2 == 2) {
					System.out.println(User.loginUserId);
					User.userInsert();
				} else if (menu2 == 3) {
					System.out.println(User.loginUserId);
					User.blackList();
				} else if (menu2 == 4) {
					System.out.println(User.loginUserId);
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
				}
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	public static void loginMenu() {
		boolean b = true;
		while (b) {
			System.out.println(User.loginUserId);
			System.out.println("==================================================================");
			System.out.println("1. 물품리스트/검색 2. 물품등록 3. 등록물품수정 4. 회원메뉴 5. 로그아웃");
			System.out.println("==================================================================");
			System.out.print("이용하실 메뉴를 입력하세요 >> ");
			menu1 = scn.nextLine();
			menu2 = Integer.parseInt(menu1) ;
			
			if (menu2 == 1) {
				Product.productSelectList();
				
			} else if (menu2 == 2) {
				Product.productInsert();
				System.out.println(User.loginUserId);
			} else if (menu2 == 3) {
				
			} else if (menu2 == 4) {
				memberMenu();
			} else if (menu2 == 5) {
				System.out.println("로그아웃 합니다.");
				main();
			}
		}

	}

	private static void memberMenu() {
		boolean b = true;
		while (b) {
			System.out.println("=============================================");
			System.out.println("1. 회원정보 2. 회원정보 수정 3. 회원탈퇴 4. 돌아가기");
			System.out.println("=============================================");
			System.out.print("이용하실 메뉴를 입력하세요 >> ");
			menu1 = scn.nextLine();
			menu2 = Integer.parseInt(menu1) ;
			if (menu2 == 1) {
				User.selectUser();
			} else if (menu2 == 2) {
				User.userUpdate();
			} else if (menu2 == 3) {
				User.userDelete();
			} else if (menu2 == 4) {
				loginMenu();
			}
		}

	}

}
