package co.jin.pj.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.jin.pj.product.service.ProductService;
import co.jin.pj.product.service.ProductVO;
import co.jin.pj.product.serviceImpl.ProductServiceImpl;

public class Product {
	Scanner scn = new Scanner(System.in);

	public void productSelectList() {
		ProductService product = new ProductServiceImpl();
		List<ProductVO> list = new ArrayList(ProductVO)();
		list = product.selectListProduct();
		
		for (ProductVO vo : list) {
			vo.toString();
		}
	}
	
	
	public void productInsert() { // 판매글 등록
		ProductVO vo = new ProductVO();
		System.out.println("물품");
		
		
		
	}
	
	
	
	

}
