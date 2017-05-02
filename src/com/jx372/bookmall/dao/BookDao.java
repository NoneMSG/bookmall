package com.jx372.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.bookmall.vo.BookVo;



public class BookDao {
	
	private Connection getConnection() throws SQLException {

		Connection conn = null;

		try {
			// 1. driver loading
			Class.forName("com.mysql.jdbc.Driver");

			// 2. Connecting
			String url = "jdbc:mysql://localhost:3306/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver is not found");
		}
		return conn;
	}
	
	public boolean insert(BookVo bookVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			
			String sql = "insert into book values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bookVo.getTitle());
			pstmt.setInt(2, bookVo.getPrice());
			pstmt.setInt(3, bookVo.getCategoryNo());
		
			int count = pstmt.executeUpdate();
			return count == 1;

		} catch (SQLException e) {
			System.out.println("error" + e);
			return false;
		} finally {
			/* 자원정리 */
			try { // open의 반대순으로 정리
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<BookVo> getList() {
		List list = new ArrayList<BookVo>();

		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;

		try {

			conn = getConnection();

			// 3. create statement
			stmt = conn.createStatement();

			// 4. run SQL
			
			String sql="select b.no, b.title, c.name, b.price"+ 
						" from book b, category c"+
						" where b.category_no=c.no";
			rs = stmt.executeQuery(sql);
			
			
			while (rs.next()) {
				Integer no = rs.getInt(1);
				String title = rs.getString(2);
				String categoryName = rs.getString(3);
				Integer price = rs.getInt(4);
				

				BookVo bookVo = new BookVo();
				bookVo.setNo(no);
				bookVo.setTitle(title);
				bookVo.setPrice(price);
				bookVo.setCategoryName(categoryName);

				list.add(bookVo);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("error" + e);
			return list;
		} finally {
			/* 자원정리 */
			try { // open의 반대순으로 정리
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public BookVo get(Integer val) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookVo bookVo = null;
		try {
			conn = getConnection();
			// 3. be ready statement 쿼리를 날리지 않고 default값으로 준비 시켜 놓는다.
			String sql = "select no, title, price, categoryNo from book where no=?";
			pstmt = conn.prepareStatement(sql);

			// 4. binding
			pstmt.setInt(1, val);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				bookVo = new BookVo();

				Integer no = rs.getInt(1);
				String title = rs.getString(2);
				Integer price = rs.getInt(3);
				Integer categoryNo = rs.getInt(4);

				
				bookVo.setNo(no);
				bookVo.setTitle(title);
				bookVo.setPrice(price);
				bookVo.setCategoryNo(categoryNo);
			}

			return bookVo;
		} catch (SQLException e) {
			System.out.println("error" + e);
			return bookVo;
		} finally {
			/* 자원정리 */
			try { // open의 반대순으로 정리
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public BookVo get(String name) {
		return null;
	}

	public boolean delete(Integer no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookVo bookVo = null;
		try {
			conn = getConnection();
			// 3. be ready statement 쿼리를 날리지 않고 default값으로 준비 시켜 놓는다.
			String sql = "delete from book where no=?";
			pstmt = conn.prepareStatement(sql);

			// 4. binding
			pstmt.setLong(1, no);

			int count = pstmt.executeUpdate();
			return (count == 1);

		} catch (SQLException e) {
			System.out.println("error" + e);
			return false;
		} finally {
			/* 자원정리 */
			try { // open의 반대순으로 정리
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean update(BookVo bookVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			// 3. be ready statement 쿼리를 날리지 않고 default값으로 준비 시켜 놓는다.
			String sql = "update book set no=?, title =?, price=?, catergoryNo=? where no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, bookVo.getNo());
			pstmt.setString(2, bookVo.getTitle());
			pstmt.setInt(3, bookVo.getPrice());
			pstmt.setInt(4, bookVo.getCategoryNo());

			int count = pstmt.executeUpdate();

			return (count == 1);

		} catch (SQLException e) {
			System.out.println("error" + e);
			return false;
		} finally {
			/* 자원정리 */
			try { // open의 반대순으로 정리
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	

		
}
