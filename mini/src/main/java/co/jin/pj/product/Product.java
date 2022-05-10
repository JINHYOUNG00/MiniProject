package co.jin.pj.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.jin.pj.product.service.ProductService;
import co.jin.pj.product.service.ProductVO;
import co.jin.pj.product.serviceImpl.ProductServiceImpl;
import lombok.ToString;

public class Product {
	static Scanner scn = new Scanner(System.in);
	static ProductService service = new ProductServiceImpl();
	static List<ProductVO> list = new ArrayList<ProductVO>();

	public static void productSelectList() {
		System.out.println("============ 물 품 명 단 ============");
		list = service.selectListProduct();
		for (ProductVO vo : list) {
			System.out.printf("글번호: %d  글제목 : %s \n", vo.getProductId(), vo.getProductTitle());
			System.out.printf("카테고리 : %s  가격 : %d  ID : %s \n", vo.getProductCategory(), vo.getProductPrice(),
					vo.getUserId());
			System.out.println("======================================");

		}

	}

	public static void selectProduct() {
		ProductVO vo = new ProductVO();
		System.out.println("조회할 글번호 >>");
		vo.setProductId(scn.nextInt());
		scn.nextLine();

		vo = service.selectProduct(vo);

		System.out.printf("글번호 : %d  글제목 : %s  품목 : %s  가격 : %d \n", vo.getProductId(), vo.getProductTitle(),
				vo.getProductCategory(), vo.getProductPrice());
		System.out.printf("상세내용 : %s  글쓴이 : %s \n", vo.getProductDetail(), vo.getUserId());
	}

	public static void productInsert() { // 판매글 등록
		ProductVO vo = new ProductVO();
		int cnt = 0;
		while (true) {
			if (cnt == service.selectProduct(vo).getProductId()) {
				cnt++;
			} else 
				break;
		}
		System.out.println("============ 물 품 등 록 ============");
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

		service.insertProduct(vo);
	}

}
