package co.jin.pj.product.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.jin.pj.product.Product;
import co.jin.pj.product.service.ProductService;
import co.jin.pj.product.service.ProductVO;
import co.jin.pj.dao.DataSource;

public class ProductServiceImpl implements ProductService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn = dataSource.getConnection(); // 커넥션 연결
	private PreparedStatement psmt; // sql 명령실행
	private ResultSet rs; // select 결과를 담음
	
	ProductVO vo = new ProductVO();
		
	@Override
	public List<ProductVO> selectListProduct() { // 물품목록조회
		List<ProductVO> products = new ArrayList<ProductVO>();
		ProductVO product;
		String sql = "SELECT PRODUCT_ID, u.user_id, PRODUCT_ID, PRODUCT_TITLE, PRICE, PRODUCT_CATEGORY, PRODUCT_DETAIL \r\n"
				+ "FROM products p JOIN users u\r\n"
				+ "ON p.user_id = u.user_id"; //"SELECT PRODUCT_ID, USER_ID, PRODUCT_ID, PRODUCT_TITLE, PRICE, PRODUCT_CATEGORY, PRODUCT_DETAIL FROM PRODUCTS"; // ORDER BY PRODUCT_ID DESC";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			
			while (rs.next()) {
				product = new ProductVO();
				product.setProductId(rs.getInt("PRODUCT_ID"));
				product.setUserId(rs.getString("User_ID"));
				product.setProductTitle(rs.getString("PRODUCT_TITLE"));
				product.setProductPrice(rs.getInt("PRICE"));
				product.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
				product.setProductDetail(rs.getString("PRODUCT_DETAIL"));
				products.add(product);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public ProductVO selectProduct(ProductVO product) {
		
		String sql = "SELECT PRODUCT_ID, PRODUCT_TITLE, PRODUCT_CATEGORY, PRICE, PRODUCT_DETAIL, u.USER_ID"
				+ "FROM PRODUCTS p JOIN USERS u"
				+ "ON p.USER_ID = u.USER_ID"
				+ "WHERE PRODUCT_ID = ?" ;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, product.getProductId());
			
			if(rs.next()) {
				vo = new ProductVO();
				vo.setProductId(rs.getInt("PRODUCT_ID"));
				vo.setProductTitle(rs.getString("PRODUCT_TITLE"));
				vo.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
				vo.setProductPrice(rs.getInt("PRICE"));
				vo.setProductDetail(rs.getString("PRODUCT_DETAIL"));
				vo.setUserId(rs.getString("USER_ID"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}

	@Override
	public int insertProduct(ProductVO product) { //물품 등록
		int n = 0;
		String sql = "INSERT INTO PRODUCTS VALUES(?,?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(7, product.getUserId());
			psmt.setString(2, product.getProductTitle());
			psmt.setString(4, product.getProductCategory());
			psmt.setInt(3, product.getProductPrice());
			psmt.setString(5, product.getProductDetail());
			psmt.setInt(1, product.getProductId());
			psmt.setString(6, product.getCustomerName());
			
			n = psmt.executeUpdate();
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
