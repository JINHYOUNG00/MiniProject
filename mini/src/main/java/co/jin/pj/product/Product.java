package co.jin.pj.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.jin.pj.main.Menu;
import co.jin.pj.product.service.ProductService;
import co.jin.pj.product.service.ProductVO;
import co.jin.pj.product.serviceImpl.ProductServiceImpl;
import co.jin.pj.user.User;
import co.jin.pj.user.service.UserService;
import co.jin.pj.user.service.UserVO;
import co.jin.pj.user.serviceImpl.UserServiceImpl;

public class Product {
	static Scanner scn = new Scanner(System.in);
	static ProductService service = new ProductServiceImpl();
	static UserService service2 = new UserServiceImpl();

	static List<ProductVO> list = new ArrayList<ProductVO>();

	public static int selectProduct;

	public static void productSelectList() {
		User.clearScreen();
		System.out.println(
				"물 품 명 단 / 검 색 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		list = service.selectListProduct();
		for (ProductVO vo : list) {

			System.out.printf("글번호: %3d  |%50s  |품목: %10s  |%10d원|글쓴이: %10s|%s \n", vo.getProductId(),
					vo.getProductTitle(), vo.getProductCategory(), vo.getProductPrice(), vo.getUserId(),
					vo.getStatus());
//			System.out.printf("카테고리 : %s  가격 : %d  ID : %s \n", vo.getProductCategory(), vo.getProductPrice(), vo.getUserId());
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
//		selectProduct();
		Menu.productMenu();
	}

	public static void productSelectList2() {
		User.clearScreen();
		System.out.println(
				"물 품 명 단 / 검 색 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		list = service.selectListProduct2();
		for (ProductVO vo : list) {

			System.out.printf("글번호: %3d  |%50s  |품목: %10s  |%10d원|글쓴이: %10s|%s \n", vo.getProductId(),
					vo.getProductTitle(), vo.getProductCategory(), vo.getProductPrice(), vo.getUserId(),
					vo.getStatus());
//			System.out.printf("카테고리 : %s  가격 : %d  ID : %s \n", vo.getProductCategory(), vo.getProductPrice(), vo.getUserId());
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
//		selectProduct();
		Menu.productMenu();
	}

	public static void productSelectList3() { // 내가 구입가능한 물품목록조회
		User.clearScreen();
		System.out.println(
				"물 품 명 단 / 검 색 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		list = service.selectListProduct3();
		for (ProductVO vo : list) {

			System.out.printf("글번호: %3d  |%50s  |품목: %10s  |%10d원|글쓴이: %10s|%s \n", vo.getProductId(),
					vo.getProductTitle(), vo.getProductCategory(), vo.getProductPrice(), vo.getUserId(),
					vo.getStatus());
//			System.out.printf("카테고리 : %s  가격 : %d  ID : %s \n", vo.getProductCategory(), vo.getProductPrice(), vo.getUserId());
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
//		selectProduct();
		Menu.productMenu();
	}

	public static void productInsert() { // 판매글 등록
		ProductVO vo = new ProductVO();

		User.clearScreen();
		System.out.println(
				"물 품 등 록 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("돌아가기 0번");
//		System.out.print("ID >>");
		vo.setUserId(User.loginUserId);

		System.out.print("제목 >>");
		String title = scn.nextLine();
		if (title.equals("0")) {
			User.clearScreen();
			Menu.loginMenu();
		} else {
			System.out.print("가격 >>");
			int price = scn.nextInt();
			scn.nextLine();
			if (price == 0) {
				User.clearScreen();
				Menu.loginMenu();
			} else {
				System.out.print("물품 품목 >>");
				String category = scn.nextLine();
				if (category.equals("0")) {
					User.clearScreen();
					Menu.loginMenu();
				} else {
					System.out.print("물품 상세사항 >>");
					String detail = scn.nextLine();
					if (detail.equals("0")) {
						User.clearScreen();
						Menu.loginMenu();
					} else {
						vo.setProductTitle(title);
						vo.setProductPrice(price);
						vo.setProductCategory(category);
						vo.setProductDetail(detail);
						vo.setCustomerName(null);
						vo.setStatus("거래가능");

						service.insertProduct(vo); // productid 없는 상태의 product >> db (시퀀스 붙어서 )
					}
				}
			}
		}
	}

	public static void updateProduct() { // 등록물품 수정
		ProductVO vo = new ProductVO();
		System.out.println(
				"등 록 물 품 수 정 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		String userId = User.loginUserId;
		vo.setUserId(userId);
		System.out.println("0.취소");
		System.out.println("수정할 글번호 >>");
		int productId = scn.nextInt();
		scn.nextLine();
		vo.setProductId(productId);

		if (service.selectProduct(vo).getStatus().equals("거래가능")) {

			if (productId == 0) {
				User.clearScreen();
				productSelectList();
			} else {
				if (userId.equals(service.selectProduct(vo).getUserId())) {
					System.out.print("수정할 글제목 >>");
					String title = scn.nextLine();
					vo.setProductTitle(title);
					if (title.equals("0")) {
						User.clearScreen();
						productSelectList();
					} else {

						System.out.print("수정할 가격 >>");
						int price = scn.nextInt();
						scn.nextLine();
						vo.setProductPrice(price);
						if (price == 0) {
							User.clearScreen();
							productSelectList();
						} else {

							System.out.print("수정할 품목명 >>");
							String category = scn.nextLine();
							vo.setProductCategory(category);
							if (category.equals("0")) {
								User.clearScreen();
								productSelectList();
							} else {

								System.out.print("수정할 세부사항 >>");
								String detail = scn.nextLine();
								vo.setProductDetail(detail);
								service.updateProduct(vo);

								User.clearScreen();
								productSelectList();
								System.out.println("수정완료");
							}
						}
					}
				} else {
					System.out.println("해당 물품은 다른 사용자의 물품입니다.");
				}
			}
		} else if (service.selectProduct(vo).getStatus().equals("거래중")) {
			System.out.println("거래중인 물품입니다.");

		} else if (service.selectProduct(vo).getStatus().equals("거래완료")) {
			System.out.println("거래 완료된 물품입니다.");
		}
	}

	public static void deleteProduct() {
		System.out.println(
				"등 록 물 품 삭 제 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		ProductVO vo = new ProductVO();
		String userId = User.loginUserId;
		vo.setUserId(userId);
		System.out.print("삭제할 물품번호 입력 (0.취소)>>");
		int productId = scn.nextInt();
		scn.nextLine();
		if (productId == 0) {
			User.clearScreen();
			productSelectList();
		} else if (productId != 0) {
			vo.setProductId(productId);
			if (userId.equals(service.selectProduct(vo).getUserId())) {

				if (service.selectProduct(vo).getStatus().equals("거래중")) {
					System.out.println("거래 중인 물품입니다.");

				} else {

					service.deleteProduct(vo);
					System.out.println(productId + " 물품이 삭제되었습니다.");
					productSelectList();
				}
			} else {
				System.out.println("해당 물품은 다른 사용자의 물품입니다.");
			}

		}
	}

	public static void selectProductId() { // 글번호를 넣었을때 구매자 정보를 알려줌
		ProductVO vo = new ProductVO();
		UserVO vo2 = new UserVO();
		System.out.println("연락처 조회할 글번호 (0.취소) >>");
		int input = scn.nextInt();
		scn.nextLine();
		vo.setProductId(input);
		if (!User.loginUserId.equals(service.selectProduct(vo).getUserId())) {
			System.out.println("해당사항없음");
		} else {

			if (input != 0) {

				String customerId = service.selectProduct(vo).getCustomerName();
				vo2.setUserId(customerId);
				vo2 = service2.selectUser2(vo2);

				System.out.println(
						"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("구매자ID: %5s|구매자 연락처: %10s| \n", vo2.getUserId(), vo2.getUserPhone(),
						vo2.getUserPhone());
				System.out.println(
						"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			} else if (input == 0) {
				User.clearScreen();
				Menu.memberMenu();
			}
		}

	}

	public static void selectBuyerId() { // 글번호를 넣었을때 판매자 정보를 알려줌
		ProductVO vo = new ProductVO();
		UserVO vo2 = new UserVO();
		System.out.println("연락처 조회할 글번호 (0.취소) >>");
		int input = scn.nextInt();
		scn.nextLine();
		vo.setProductId(input);
		if (!User.loginUserId.equals(service.selectProduct(vo).getCustomerName())) {
			System.out.println("해당사항없음");
		} else {

			if (input != 0) {

				String sellerId = service.selectProduct(vo).getUserId();
				vo2.setUserId(sellerId);
				vo2 = service2.selectUser2(vo2);

				System.out.println(
						"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("판매자ID: %5s|판매자 연락처: %10s| \n", vo2.getUserId(), vo2.getUserPhone(),
						vo2.getUserPhone());
				System.out.println(
						"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			} else if (input == 0) {
				User.clearScreen();
				Menu.memberMenu();
			}
		}

	}

	public static void selectProduct() {
		ProductVO vo = new ProductVO();
		UserVO vo2 = new UserVO();
		System.out.print("조회할 글번호 (0.취소)>>");
		int input = scn.nextInt();
		scn.nextLine();

		vo.setProductId(input);
		selectProduct = input;
		String sellerId = service.selectProduct(vo).getUserId();
		vo2.setUserId(sellerId);
		if (input != 0) {
			if (service.selectProduct(vo).getProductCategory() != null && (service2.selectUser2(vo2).getBlackList() != null && service2.selectUser2(vo2).getBlackList().equals("N"))) {
				vo = service.selectProduct(vo);
				User.clearScreen();
				System.out.println(
						"■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.printf("%3d|%50s|품목: %10s|%10d원|글쓴이: %10s|%s \n", vo.getProductId(), vo.getProductTitle(),
						vo.getProductCategory(), vo.getProductPrice(), vo.getUserId(), vo.getStatus());
				System.out.println(
						"상세내용----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%s \n", vo.getProductDetail());
				System.out.println(
						"■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				buy();
				// 구입 의사 질문 => y => 결재진행 => 거래중으로 표기 및 해당 물건 customer_name에 현재 구매자 user_id 입력
				// n => 뒤로가기
			} else {
				System.out.println("존재하지않는 글입니다.");
			}
		} else if (input == 0) {
			User.clearScreen();
			productSelectList();
		}
	}

	public static void sellProcessList() { //
		User.clearScreen();
//		ProductVO vo2 = new ProductVO();
//		String userId = User.loginUserId;
//		vo2.setUserId(userId);
//		String customerId = service.selectProduct(vo2).getCustomerName(); 
//		System.out.println(customerId);
//		
		System.out.println(
				"판 매 요 청 물 품 명 단 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		list = service.sellProcessList();
		for (ProductVO vo : list) {
			System.out.printf("글번호: %3d  |구매자ID: %6s  |글제목: %50s  |%7d원|%s \n", vo.getProductId(), vo.getCustomerName(),
					vo.getProductTitle(), vo.getProductPrice(), vo.getStatus());
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}

		selectProductId();

	}

	public static void buyProcessList() {
		User.clearScreen();
		System.out.println(
				"구 매 요 청 물 품 명 단 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

		list = service.buyProcessList();
		for (ProductVO vo : list) {
			System.out.printf("글번호: %3d  |판매자ID: %6s  |글제목: %50s  |%7d원|%s \n", vo.getProductId(), vo.getUserId(),
					vo.getProductTitle(), vo.getProductPrice(), vo.getStatus());
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}

		Menu.buyerMenu();

	}

	public static void buy() {
		ProductVO vo = new ProductVO();
		UserVO vo2 = new UserVO();
		System.out.print(selectProduct + "번 물품을 구입신청하시겠습니까?(y/n) >>");

		vo.setProductId(selectProduct);

		String input = scn.nextLine();
		if (input.equals("y")) {
			if (User.loginUserId.equals(service.selectProduct(vo).getUserId())) {
				System.out.println("본인 물품은 구입 할 수 없습니다.");

			} else {

				int input2 = selectProduct;
				if (service.selectProduct(vo).getStatus().equals("거래가능")) {
					vo.setProductId(input2);
					int price = service.selectProduct(vo).getProductPrice();
					vo.setProductPrice(price);
					vo2.setUserId(User.loginUserId);
					if (service2.selectUser2(vo2).getPoint() >= price) {
						
					service.buyProduct(vo);
					System.out.println("구입신청되었습니다. \n#####  판매자 정보는 회원메뉴 5번 구매중인물품조회에 있습니다.  ######");
					
					} else {
						System.out.println("금액이 부족합니다.");
					}
				} else if (!service.selectProduct(vo).getStatus().equals("거래가능")) {
					System.out.println("판매중인 물품이 아닙니다.");
				}
			}
		} else if (input.equals("n")) {
			productSelectList();
		}

	}

	public static void buyconfirm() {
		ProductVO vo = new ProductVO();
		UserVO vo2 = new UserVO();
		System.out.print("구매 확정할 글번호 입력 >>");
		int input = scn.nextInt();
		scn.nextLine();
		vo.setProductId(input);
		int price = service.selectProduct(vo).getProductPrice();
		String sellerId = service.selectProduct(vo).getUserId();
		vo2.setUserId(sellerId);
		if (service2.selectUser(vo2).getBlackList() != null && service2.selectUser(vo2).getBlackList().equals("Y")) {
			System.out.println("판매자가 블랙리스트에 지정되어 구매확정할 수 없습니다. 구매 취소해주세요.");
		} else {
			
			if (User.loginUserId.equals(service.selectProduct(vo).getCustomerName())) {
				vo.setUserId(sellerId);
				vo.setProductPrice(price);
				service.purchaseConfirm(vo);
				System.out.println("구매 확정되었습니다.");
			} else {
				System.out.println("해당사항 없습니다.");
			}
		}
	}

	public static void refund() {
		ProductVO vo = new ProductVO();
		UserVO vo2 = new UserVO();
		System.out.print("환불할 글 번호 입력 >>");
		int input = scn.nextInt();
		scn.nextLine();
		vo.setProductId(input);
		int price = service.selectProduct(vo).getProductPrice();
		vo2.setPoint(price);
		
		vo2.setPoint(input);
		if (User.loginUserId.equals(service.selectProduct(vo).getCustomerName())) {
			String sellerId = service.selectProduct(vo).getUserId();
			vo2.setUserId(sellerId);
			vo2.setRefund(input);
			service2.refundUpdate(vo2);
			System.out.println("환불되었습니다.");
			if (service2.selectUser2(vo2).getRefund() >= 10) {
				service2.addBlackList(vo2);
			}
		} else {
			System.out.println("구입한 물품이 아닙니다.");
		}

	}

}
