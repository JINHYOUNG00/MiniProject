package co.jin.pj.product.service;

import java.util.List;


public interface ProductService {
	
	List<ProductVO> selectListProduct(); //물품리스트
	ProductVO selectProduct(ProductVO product); //하나 물품 검색
	int insertProduct(ProductVO product); //물품 등록
	int updateProduct(ProductVO product); //물품 갱신
	int deleteProduct(ProductVO product); //물품 삭제
	int buyProduct(ProductVO product);
	List<ProductVO> sellProcessList();
	ProductVO sellProcess(ProductVO product);
	List<ProductVO> buyProcessList();
	List<ProductVO> selectListProduct2();
	int purchaseConfirm(ProductVO product);
	List<ProductVO> selectListProduct3();
	ProductVO selectProduct2(ProductVO product);

}
