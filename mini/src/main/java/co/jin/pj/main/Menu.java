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
//			try {
			System.out.println(
					"┌■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■┐");
			System.out.println(
					"│ 1. 로그인												    					  │ \n│-------------------------------------------------------------------------------------------------------------------------------------------------│\n"
							+ "│ 2. 회원가입												    					  │ \n│-------------------------------------------------------------------------------------------------------------------------------------------------│\n"
							+ "│ 3. 블랙리스트												    					  │ \n│-------------------------------------------------------------------------------------------------------------------------------------------------│\n"
							+ "│ 9. 종료												    					          │");
			System.out.println(
					"└■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■┘");
			System.out.print("이용하실 메뉴를 입력하세요 >> ");
			menu1 = scn.nextLine();
			if (menu1.equals("1") || menu1.equals("2") || menu1.equals("3") || menu1.equals("9")) {
				menu2 = Integer.parseInt(menu1);
				if (menu2 == 1) {
					User.login();
				} else if (menu2 == 2) {
					User.userInsert();
				} else if (menu2 == 3) {
					User.blackList();
				} else if (menu2 == 9) {
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
				}
			} else {
				System.out.println("메뉴에 있는 선택지를 선택해주세요");
			}
//			} catch (Exception e) {
//				System.out.println("잘못된 입력입니다.");
//			}
		}
	}

	public static void loginMenu() {
		boolean b = true;
		while (b) {
			System.out.println(
					"┌■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■┐");
			System.out.println(
					"│ 1. 물품리스트/검색					     				            		    					  │ \n│-------------------------------------------------------------------------------------------------------------------------------------------------│\n"
							+ "│ 2. 물품등록												    					  │ \n│-------------------------------------------------------------------------------------------------------------------------------------------------│\n"
							+ "│ 3. 회원메뉴 												    					  │ \n│-------------------------------------------------------------------------------------------------------------------------------------------------│\n"
							+ "│ 9. 로그아웃				    							    					          │");
			System.out.println(
					"└■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■┘");
			System.out.print("이용하실 메뉴를 입력하세요 >> ");
			menu1 = scn.nextLine();
			if (menu1.equals("1") || menu1.equals("2") || menu1.equals("3") || menu1.equals("9")) {
				menu2 = Integer.parseInt(menu1);

				if (menu2 == 1) {
					User.clearScreen();
					Product.productSelectList();

				} else if (menu2 == 2) {
					User.clearScreen();
					Product.productInsert();
				} else if (menu2 == 3) {
					User.clearScreen();
					memberMenu();
				} else if (menu2 == 9) {
					User.clearScreen();
					System.out.println("로그아웃 합니다.");
					main();
				}
			} else {
				System.out.println("메뉴에 있는 선택지를 입력해주세요");
			}
		}
	}

	public static void memberMenu() {
		boolean b = true;
		while (b) {
			System.out.println(
					"┌■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■┐");
			System.out.println(
					"│ 1. 회원정보 조회					     				            		    					  │ \n│-------------------------------------------------------------------------------------------------------------------------------------------------│\n"
							+ "│ 2. 회원정보 수정												    					  │ \n│-------------------------------------------------------------------------------------------------------------------------------------------------│\n"
							+ "│ 3. 회원 탈퇴												    					  │ \n│-------------------------------------------------------------------------------------------------------------------------------------------------│\n"
							+ "│ 4. 구매요청 받은 물품 목록/ 구매자 연락처 조회									    					  │ \n│-------------------------------------------------------------------------------------------------------------------------------------------------│\n"
							+ "│ 5. 구매요청 한 물품 목록/ 판매자 연락처 조회/ 구매확정 및 반품							    					  │ \n│-------------------------------------------------------------------------------------------------------------------------------------------------│\n"
							+ "│ 9. 돌아가기				    							    					          │");
			System.out.println(
					"└■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■┘");
			System.out.print("이용하실 메뉴를 입력하세요 >> ");
			menu1 = scn.nextLine();
			if (menu1.equals("1") || menu1.equals("2") || menu1.equals("3") || menu1.equals("4") || menu1.equals("5")
					|| menu1.equals("9")) {
				menu2 = Integer.parseInt(menu1);
				if (menu2 == 1) {
					User.clearScreen();
					User.selectUser();
				} else if (menu2 == 2) {
					User.clearScreen();
					User.userUpdate();
				} else if (menu2 == 3) {
					User.clearScreen();
					User.userDelete();
				} else if (menu2 == 4) {
					Product.sellProcessList();
				} else if (menu2 == 5) {
					Product.buyProcessList();
				} else if (menu2 == 9) {
					User.clearScreen();
					loginMenu();
				}
			} else {
				System.out.println("메뉴에 있는 선택지를 입력해주세요.");
			}
		}

	}
//productSelectList4()
	public static void productMenu() {
		boolean b = true;
		while (b) {
			System.out.println("1. 조회/구입 2. 물품검색 3. 물품수정 4. 물품삭제 5. 내가 쓴 글 제외 목록 6.거래가능한 물품만 보기 9. 돌아가기");
			System.out.println(
					"■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.print("이용하실 메뉴를 입력하세요 >> ");
			menu1 = scn.nextLine();
			if (menu1.equals("1") || menu1.equals("2") || menu1.equals("3") || menu1.equals("4") || menu1.equals("5")|| menu1.equals("6")
					|| menu1.equals("9")) {
				menu2 = Integer.parseInt(menu1);
				if (menu2 == 1) {
					Product.selectProduct();
				} else if (menu2 == 2) {
					Product.productSelectList4();
				} else if (menu2 == 3) {
					Product.updateProduct();
				} else if (menu2 == 4) {
					Product.deleteProduct();
				} else if (menu2 == 5) {
					Product.productSelectList2();
				} else if (menu2 == 6) {
					Product.productSelectList3();
				} else if (menu2 == 9) {
					User.clearScreen();
					loginMenu();
				}
			} else {
				System.out.println("메뉴에 있는 선택지를 입력해주세요.");
			}
		}
	}

	public static void buyerMenu() {
		boolean b = true;
		while (b) {
			System.out.println("1. 판매자연락처조회 2. 구매확정 3.환불 9. 돌아가기");
			System.out.println(
					"■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.print("이용하실 메뉴를 입력하세요 >> ");
			menu1 = scn.nextLine();
			if (menu1.equals("1") || menu1.equals("2") || menu1.equals("3") || menu1.equals("9")) {
				menu2 = Integer.parseInt(menu1);
				if (menu2 == 1) {
					Product.selectBuyerId();
				} else if (menu2 == 2) {
					Product.buyconfirm();
				} else if (menu2 == 3) {
					Product.refund();
				} else if (menu2 == 9) {
					User.clearScreen();
					loginMenu();
				}
			} else {
				System.out.println("메뉴에 있는 선택지를 입력해주세요.");
			}
		}
	}

}
