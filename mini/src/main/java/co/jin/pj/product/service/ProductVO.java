package co.jin.pj.product.service;

import lombok.Data;

@Data
public class ProductVO {
	
	private int productId = 1;
	private String productTitle;
	private String productCategory;
	private int productPrice;
	private String productDetail;
	private String customerName;
	private String userId;


	

}
