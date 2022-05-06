package co.jin.pj.product.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.jin.pj.product.service.ProductService;
import co.jin.pj.product.service.ProductVO;
import co.jin.pj.dao.DataSource;

public class ProductServiceImpl implements ProductService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn = dataSource.getConnection(); // 커넥션 연결
	private PreparedStatement psmt; // sql 명령실행
	private ResultSet rs; // select 결과를 담음

	@Override
	public List<ProductVO> selectListProduct() { // 물품목록조회
		List<ProductVO> products = new ArrayList<ProductVO>();
		ProductVO product;
		String sql = "SELECT * FROM PRODUCTS";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				product = new ProductVO();
				product.setProductId(rs.getInt("productid"));
				product.setProductTitle(rs.getString("producttitle"));
				product.setProductPrice(rs.getInt("price"));
				product.setProductCategory(rs.getString("productcategory"));
				product.setProductDetail(rs.getString("productdetail"));
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public ProductVO selectProduct(ProductVO product) {

		return null;
	}

	@Override
	public int insertProduct(ProductVO product) { //물품 등록
		int n = 0;
		String sql = "INSERT INTO PRODUCTS VALUES(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, product.getProductTitle());
			psmt.setInt(2, product.getProductPrice());
			psmt.setString(3, product.getProductCategory());
			psmt.setString(4, product.getProductDetail());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

	@Override
	public int updateProduct(ProductVO product) {
		int n = 0;
		String sql = "UPDATE PRODUCTS SET TITLE = ?, "
				+ "PRICE = ?, CATEGORY = ?, DETAIL = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, product.getProductTitle());
			psmt.setInt(2, product.getProductPrice());
			psmt.setString(3, product.getProductCategory());
			psmt.setString(4, product.getProductDetail());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

	@Override
	public int deleteProduct(ProductVO product) {
		int n = 0;
		String sql = "DELETE FROM PRODUCTS WHERE PRODUCTID";
		try {
			psmt = conn.prepareStatement(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

}
