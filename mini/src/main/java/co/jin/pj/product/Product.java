package co.jin.pj.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.jin.pj.product.service.ProductService;
import co.jin.pj.product.service.ProductVO;
import co.jin.pj.product.serviceImpl.ProductServiceImpl;
import co.jin.pj.user.User;
import lombok.ToString;

public class Product {
	static Scanner scn = new Scanner(System.in);
	static ProductService service = new ProductServiceImpl();
	static List<ProductVO> list = new ArrayList<ProductVO>();
	static int cnt = 1;

	public static void productSelectList() {
		User.clearScreen();
		System.out.println("======================== 물 품 명 단 / 검 색 ========================");
		list = service.selectListProduct();
		for (ProductVO vo : list) {
			System.out.printf("글번호: %3d  |%30s  |카테고리: %4s  |%5d원|글쓴이: %5s|%s \n", vo.getProductId(),
					vo.getProductTitle(), vo.getProductCategory(), vo.getProductPrice(), vo.getUserId(),
					vo.getStatus());
//			System.out.printf("카테고리 : %s  가격 : %d  ID : %s \n", vo.getProductCategory(), vo.getProductPrice(), vo.getUserId());
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
		selectProduct();

	}

	public static void productInsert() { // 판매글 등록
		ProductVO vo = new ProductVO();

		User.clearScreen();
		System.out.println("======================== 물 품 등 록 ========================");
		System.out.print("ID >>");
		vo.setUserId(scn.nextLine());
		System.out.println("글 제목 >>");
		vo.setProductTitle(scn.nextLine());
		System.out.println("물품 카테고리 >>");
		vo.setProductCategory(scn.nextLine());
		System.out.println("물품 상세사항 >>");
		vo.setProductDetail(scn.nextLine());
		vo.setProductId(cnt);
		vo.setCustomerName(null);
		vo.setStatus("거래가능");

		service.insertProduct(vo);
	}

	public static void selectProduct() {
		ProductVO vo = new ProductVO();
		System.out.print("조회할 글번호 >>");
		vo.setProductId(scn.nextInt());
		scn.nextLine();
		vo = service.selectProduct(vo);
		User.clearScreen();
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%3d|%30s|품목: %4s|%5d원|글쓴이: %5s \n", vo.getProductId(), vo.getProductTitle(),
				vo.getProductCategory(), vo.getProductPrice(), vo.getUserId());
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("상세내용 : %s \n", vo.getProductDetail());
		// 구입 의사 질문 => y => 결재진행 => 거래중으로 표기(테이블 추가해야함)
		// n => 뒤로가기
		buy();
	}

	public static void buy() {
		ProductVO vo = new ProductVO();
		System.out.print("구매(y/n) >>");
		String input = scn.nextLine();
		if (input.equals("y")) {
			System.out.print("글번호 >>");
			int input2 = scn.nextInt();
			scn.nextLine();
			if (!service.selectProduct(vo).getStatus().equals("거래중")) {
				vo.setProductId(input2);
				service.buyProduct(vo);
			} else if (service.selectProduct(vo).getStatus().equals("거래중")) {
				System.out.println("거래중인 물건입니다.");
			}
			
		} else if (input.equals("n")) {
			productSelectList();
		}

	}

}
