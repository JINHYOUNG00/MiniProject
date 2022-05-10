package co.jin.pj.main;

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
	private static int menu;
	UserService service = new UserServiceImpl();
	
	
	public static void main() {

		boolean b = true;
		while (b) {
			System.out.println("======================================");
			System.out.println("1. 로그인 2. 회원가입 3. 블랙리스트 4. 종료");
			System.out.println("======================================");
			System.out.print("이용하실 메뉴를 입력하세요 >> ");
			menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				User.login();
			} else if (menu == 2) {
				User.userInsert();
			} else if (menu == 3) {
				User.blackList();
			} else if (menu == 4) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}

	public static void loginMenu() {
		boolean b = true;
		while (b) {
			System.out.println("==================================================================");
			System.out.println("1. 물품리스트 2. 물품검색 3. 물품등록 4. 등록물품수정 5. 회원메뉴 6. 로그아웃");
			System.out.println("==================================================================");
			System.out.print("이용하실 메뉴를 입력하세요 >> ");
			menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				Product.productSelectList();
			} else if (menu == 2) {
				Product.selectProduct();
			} else if (menu == 3) {
				Product.productInsert();
			} else if (menu == 4) {
				
			} else if (menu == 5) {
				memberMenu();
			} else if (menu == 6) {
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
			menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				User.selectUser();
			} else if (menu == 2) {
				User.userUpdate();
			} else if (menu == 3) {
				User.userDelete();
			} else if (menu == 4) {
				loginMenu();
			}
		}

	}

	

}
