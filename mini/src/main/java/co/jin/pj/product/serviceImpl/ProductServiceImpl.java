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
import co.jin.pj.user.User;
import co.jin.pj.dao.DataSource;

public class ProductServiceImpl implements ProductService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn = dataSource.getConnection(); // 커넥션 연결
	private PreparedStatement psmt; // sql 명령실행
	private ResultSet rs; // select 결과를 담음
	
//	ProductVO vo = new ProductVO();
		
	@Override
	public List<ProductVO> selectListProduct() { // 물품목록조회
		ProductVO vo = new ProductVO();
		List<ProductVO> products = new ArrayList<ProductVO>();
		ProductVO product;
		String sql = "SELECT PRODUCT_ID, u.user_id, PRODUCT_ID, PRODUCT_TITLE, PRICE, PRODUCT_CATEGORY, PRODUCT_DETAIL, status\r\n"
				+ "FROM products p JOIN users u\r\n"
				+ "ON p.user_id = u.user_id\r\n"
				+ "order by p.product_id asc";
				/*"SELECT PRODUCT_ID, u.user_id, PRODUCT_ID, PRODUCT_TITLE, PRICE, PRODUCT_CATEGORY, PRODUCT_DETAIL \r\n"
				+ "FROM products p JOIN users u\r\n"
				+ "ON p.user_id = u.user_id";*/
				//+ "order by p.product_id desc"; //"SELECT PRODUCT_ID, USER_ID, PRODUCT_ID, PRODUCT_TITLE, PRICE, PRODUCT_CATEGORY, PRODUCT_DETAIL FROM PRODUCTS"; // ORDER BY PRODUCT_ID DESC";
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
				product.setStatus(rs.getString("status"));
				products.add(product);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}
	
	@Override
	public List<ProductVO> selectListProduct2() { // 내가 쓴 글 제외한 물품목록조회
		ProductVO vo = new ProductVO();
		List<ProductVO> products = new ArrayList<ProductVO>();
		ProductVO product;
		String sql = "SELECT PRODUCT_ID, u.user_id, PRODUCT_ID, PRODUCT_TITLE, PRICE, PRODUCT_CATEGORY, PRODUCT_DETAIL, status\r\n"
				+ "				FROM products p JOIN users u\r\n"
				+ "				ON p.user_id = u.user_id\r\n"
				+ "                where not u.user_id = ?\r\n"
				+ "				order by p.product_id asc";
				
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, User.loginUserId);
			
			rs = psmt.executeQuery();

			
			while (rs.next()) {
				product = new ProductVO();
				product.setProductId(rs.getInt("PRODUCT_ID"));
				product.setUserId(rs.getString("User_ID"));
				product.setProductTitle(rs.getString("PRODUCT_TITLE"));
				product.setProductPrice(rs.getInt("PRICE"));
				product.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
				product.setProductDetail(rs.getString("PRODUCT_DETAIL"));
				product.setStatus(rs.getString("status"));
				products.add(product);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}
	
	@Override
	public List<ProductVO> selectListProduct3() { // 내가 구입가능한 물품목록조회
		ProductVO vo = new ProductVO();
		List<ProductVO> products = new ArrayList<ProductVO>();
		ProductVO product;
		String sql = "SELECT PRODUCT_ID, u.user_id, PRODUCT_ID, PRODUCT_TITLE, PRICE, PRODUCT_CATEGORY, PRODUCT_DETAIL, status\r\n"
				+ "								FROM products p JOIN users u\r\n"
				+ "								ON p.user_id = u.user_id\r\n"
				+ "				                where not u.user_id = ? and status = '거래가능'\r\n"
				+ "								order by p.product_id asc";
				
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, User.loginUserId);
			
			rs = psmt.executeQuery();

			
			while (rs.next()) {
				product = new ProductVO();
				product.setProductId(rs.getInt("PRODUCT_ID"));
				product.setUserId(rs.getString("User_ID"));
				product.setProductTitle(rs.getString("PRODUCT_TITLE"));
				product.setProductPrice(rs.getInt("PRICE"));
				product.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
				product.setProductDetail(rs.getString("PRODUCT_DETAIL"));
				product.setStatus(rs.getString("status"));
				products.add(product);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}
	
	@Override
	public List<ProductVO> sellProcessList() { // 판매중인 물품 리스트 조회
		List<ProductVO> products = new ArrayList<ProductVO>();
		ProductVO product = new ProductVO();
		
		String sql = "SELECT PRODUCT_ID ,CUSTOMER_NAME , PRODUCT_TITLE, PRICE,  STATUS\r\n"
				+ "						FROM products p JOIN users u\r\n"
				+ "						ON p.user_id = u.user_id\r\n"
				+ "				        where u.user_id = ? and status = '거래중'\r\n"
				+ "						order by p.product_id asc";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, User.loginUserId);
			rs = psmt.executeQuery();

			
			while (rs.next()) {
				product = new ProductVO();
				product.setProductId(rs.getInt("PRODUCT_ID"));
				product.setCustomerName(rs.getString("CUSTOMER_NAME"));
				product.setProductTitle(rs.getString("PRODUCT_TITLE"));
				product.setProductPrice(rs.getInt("PRICE"));
				product.setStatus(rs.getString("STATUS"));
				products.add(product);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}
	
	@Override
	public List<ProductVO> buyProcessList() { // 구매중인 물품 리스트 조회
		List<ProductVO> products = new ArrayList<ProductVO>();
		ProductVO product = new ProductVO();
		
		String sql = "select PRODUCT_ID ,u.USER_ID , PRODUCT_TITLE, PRICE,  STATUS\r\n"
				+ "			FROM PRODUCTS P JOIN USERS u\r\n"
				+ "				ON p.USER_ID = u.USER_ID\r\n"
				+ "			WHERE CUSTOMER_NAME = ? and status = '거래중'\r\n"
				+ "			ORDER BY P.PRODUCT_ID ASC";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, User.loginUserId);
			rs = psmt.executeQuery();

			
			while (rs.next()) {
				product = new ProductVO();
				product.setProductId(rs.getInt("PRODUCT_ID"));
				product.setUserId(rs.getString("USER_ID"));
				product.setProductTitle(rs.getString("PRODUCT_TITLE"));
				product.setProductPrice(rs.getInt("PRICE"));
				product.setStatus(rs.getString("STATUS"));
				products.add(product);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}
	

	@Override
	public ProductVO selectProduct(ProductVO product) {
		ProductVO vo = new ProductVO();
		String sql = "SELECT PRODUCT_ID, PRODUCT_TITLE, PRODUCT_CATEGORY, PRICE, PRODUCT_DETAIL, u.USER_ID, status, customer_name \r\n"
				+ "FROM PRODUCTS p JOIN USERS u \r\n"
				+ "ON p.USER_ID = u.USER_ID\r\n"
				+ "WHERE PRODUCT_ID = ?" ;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, product.getProductId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo = new ProductVO();
				vo.setProductId(rs.getInt("PRODUCT_ID"));
				vo.setProductTitle(rs.getString("PRODUCT_TITLE"));
				vo.setProductPrice(rs.getInt("PRICE"));
				vo.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
				vo.setProductDetail(rs.getString("PRODUCT_DETAIL"));
				vo.setUserId(rs.getString("USER_ID"));
				vo.setStatus(rs.getString("STATUS"));
				vo.setCustomerName(rs.getString("CUSTOMER_NAME"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}
	
	@Override
	public ProductVO selectProduct2(ProductVO product) {
		ProductVO vo = new ProductVO();
		String sql = "select product_id, status \r\n"
				+ "from products\r\n"
				+ "where user_id = ?" ;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, product.getUserId());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo = new ProductVO();
				vo.setProductId(rs.getInt("PRODUCT_ID"));
				vo.setStatus(rs.getString("STATUS"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}	
	

	
	

	@Override
	public int insertProduct(ProductVO product) { //물품 등록
		int n = 0;
		String sql = "INSERT INTO PRODUCTS VALUES(PRODUCT_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, product.getProductTitle());
			psmt.setInt(2, product.getProductPrice());
			psmt.setString(3, product.getProductCategory());
			psmt.setString(4, product.getProductDetail());
			psmt.setString(5, product.getCustomerName());
			psmt.setString(6, product.getUserId());
			psmt.setString(7, product.getStatus());
			
			
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
		String sql = "DELETE FROM PRODUCTS WHERE PRODUCT_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, product.getProductId());
			
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}
//	private void productIdUpdate(int id) { // 블랙리스트 추가하기전 반품처리 횟수 지정할때 사용  => 5회 반품시 블랙리스트 등록
//		String sql = "UPDATE NOTICE SET PRODUCT_ID = PRODUCT_ID + 1 WHERE User_ID = ?";
//		
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setInt(1, id);
//			psmt.executeUpdate();
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public int buyProduct(ProductVO product) {
		int n = 0;
		String sql = "UPDATE PRODUCTS SET STATUS = '거래중', customer_name = ? WHERE PRODUCT_ID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, User.loginUserId);
			psmt.setInt(2, product.getProductId());
			
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	@Override
	public int purchaseConfirm(ProductVO product) {
		int n = 0;
		String sql = "UPDATE PRODUCTS SET STATUS = '거래완료' WHERE PRODUCT_ID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, product.getProductId());
			
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	

	@Override
	public ProductVO sellProcess(ProductVO product) {
		ProductVO vo = new ProductVO();
		String sql = "SELECT PRODUCT_ID, u.user_id,phone_number,u.address,PRODUCT_ID, PRODUCT_TITLE, PRICE, PRODUCT_CATEGORY, CUSTOMER_NAME , PRODUCT_DETAIL, status\r\n"
				+ "				FROM products p JOIN users u\r\n"
				+ "				ON p.user_id = u.user_id\r\n"
				+ "                where u.user_id = ? and status = '거래중'\r\n"
				+ "				order by p.product_id asc";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, product.getProductId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo = new ProductVO();
				vo.setProductId(rs.getInt("PRODUCT_ID"));
				vo.setProductTitle(rs.getString("PRODUCT_TITLE"));
				vo.setProductPrice(rs.getInt("PRICE"));
				vo.setProductCategory(rs.getString("PRODUCT_CATEGORY"));
				vo.setProductDetail(rs.getString("PRODUCT_DETAIL"));
				vo.setUserId(rs.getString("USER_ID"));
				vo.setStatus(rs.getString("STATUS"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}
	
	
}
