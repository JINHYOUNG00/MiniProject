package co.jin.pj.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.jin.pj.main.Menu;
import co.jin.pj.product.service.ProductService;
import co.jin.pj.product.service.ProductVO;
import co.jin.pj.product.serviceImpl.ProductServiceImpl;
import co.jin.pj.user.User;
import lombok.ToString;

public class Product {
	static Scanner scn = new Scanner(System.in);
	static ProductService service = new ProductServiceImpl();
	static List<ProductVO> list = new ArrayList<ProductVO>();

	public static int selectProduct;

	public static void productSelectList() {
		User.clearScreen();
		System.out.println(
				"물 품 명 단 / 검 색 =============================================================================================================================================================");
		list = service.selectListProduct();
		for (ProductVO vo : list) {
			System.out.printf("글번호: %3d  |%50s  |품목: %4s  |%7d원|글쓴이: %6s|%s \n", vo.getProductId(),
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
				"물 품 등 록 =============================================================================================================================================================");
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
				"등 록 물 품 수 정 =============================================================================================================================================================");
		String userId = User.loginUserId;
		vo.setUserId(userId);
		System.out.println( "0.돌아가기");
		System.out.println("수정할 글번호 >>");
		int productId = scn.nextInt();
		scn.nextLine();
		if (productId == 0) {
			User.clearScreen();
			productSelectList();
		} else {
			vo.setProductId(productId);
			if (userId.equals(service.selectProduct(vo).getUserId())) {
				System.out.print("수정할 글제목 >>");
				String title = scn.nextLine();
				if (title.equals("0")) {
					User.clearScreen();
					productSelectList();
				} else {
					vo.setProductTitle(title);

					System.out.print("수정할 가격 >>");
					int price = scn.nextInt();
					scn.nextLine();
					if (price == 0) {
						User.clearScreen();
						productSelectList();
					} else {
						vo.setProductPrice(price);

						System.out.print("수정할 품목명 >>");
						String category = scn.nextLine();
						if (category.equals("0")) {
							User.clearScreen();
							productSelectList();
						} else {
							vo.setProductCategory(category);

							System.out.print("수정할 세부사항 >>");
							String detail = scn.nextLine();
							vo.setProductDetail(detail);

							User.clearScreen();
							System.out.println("수정완료");
							service.updateProduct(vo);
						}
					}
				}
			} else {
				System.out.println("해당 물품은 다른 사용자의 물품입니다.");
			}
		}
	}

	public static void deleteProduct() {
		System.out.println(
				"등 록 물 품 삭 제 =============================================================================================================================================================");
		ProductVO vo = new ProductVO();
		String userId = User.loginUserId;
		vo.setUserId(userId);
		System.out.print("삭제할 물품번호 입력 >>");
		int productId = scn.nextInt();
		scn.nextLine();
		vo.setProductId(productId);

		if (userId.equals(service.selectProduct(vo).getUserId())) {
			System.out.println(productId + " 물품이 삭제되었습니다.");
			service.deleteProduct(vo);
			productSelectList();
		} else {
			System.out.println("해당 물품은 다른 사용자의 물품입니다.");
		}

	}

	public static void selectProduct() {
		ProductVO vo = new ProductVO();
		System.out.print("조회할 글번호 (돌아가기 0번)>>");
		int input = scn.nextInt();
		scn.nextLine();
		if (input != 0) {
			selectProduct = input;
			vo.setProductId(input);
			vo = service.selectProduct(vo);
			User.clearScreen();
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%3d|%30s|품목: %4s|%5d원|글쓴이: %5s|%s \n", vo.getProductId(), vo.getProductTitle(),
					vo.getProductCategory(), vo.getProductPrice(), vo.getUserId(), vo.getStatus());
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("상세내용 \n %s \n", vo.getProductDetail());
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

			buy();
			// 구입 의사 질문 => y => 결재진행 => 거래중으로 표기 및 해당 물건 customer_name에 현재 구매자 user_id 입력
			// n => 뒤로가기
		} else if (input == 0) {
			User.clearScreen();
			productSelectList();
		}
	}
	
	public static void sellProcess() {
		User.clearScreen();
		System.out.println(
				"물 품 명 단 / 검 색 =============================================================================================================================================================");
		list = service.sellProcess();
		for (ProductVO vo : list) {
			System.out.printf("글번호: %3d  |%50s  |품목: %4s  |%7d원|글쓴이: %6s|%s \n", vo.getProductId(),
					vo.getProductTitle(), vo.getProductCategory(), vo.getProductPrice(), vo.getUserId(),
					vo.getStatus());
//			System.out.printf("카테고리 : %s  가격 : %d  ID : %s \n", vo.getProductCategory(), vo.getProductPrice(), vo.getUserId());
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
//		selectProduct();
		Menu.productMenu();

	}
	
	

	public static void buy() {
		ProductVO vo = new ProductVO();
		System.out.print(selectProduct + "번 물품을 구입하시겠습니까?(y/n) >>");

		vo.setProductId(selectProduct);

		String input = scn.nextLine();
		if (input.equals("y")) {
			if (User.loginUserId.equals(service.selectProduct(vo).getUserId())) {
				System.out.println("본인 물품은 구입 할 수 없습니다.");

			} else {

				int input2 = selectProduct;
				if (!service.selectProduct(vo).getStatus().equals("거래중")) {
					vo.setProductId(input2);
					service.buyProduct(vo);
				} else if (service.selectProduct(vo).getStatus().equals("거래중")) {
					System.out.println("거래중인 물건입니다.");
				}
			}
		} else if (input.equals("n")) {
			productSelectList();
		}

	}
	
	

}
