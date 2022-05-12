package co.jin.pj.product.service;

import lombok.Data;

@Data
public class ProductVO {
	
	private int productId;
	private String productTitle;
	private String productCategory;
	private int productPrice;
	private String productDetail;
	private String customerName;
	private String userId;
	private String status;
	private String phoneNum;
	private String address;
	
	public ProductVO() {}

	public ProductVO(String productTitle, String productCategory, int productPrice, String productDetail,
			String customerName, String userId, String status) {
		this.productTitle = productTitle;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productDetail = productDetail;
		this.customerName = customerName;
		this.userId = userId;
		this.status = status;
	}
	
	


	

}
