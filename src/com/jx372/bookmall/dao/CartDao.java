package com.jx372.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.bookmall.vo.CartVo;

public class CartDao {

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
	
	public boolean insert(CartVo cartVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
						
			String sql = "insert into cart values( "+
					     " (select no from book where no=?) , "+
					     " (select no from member where no= ?) , "+
						 " ?) ";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cartVo.getBookNo());
			pstmt.setInt(2, cartVo.getMemNo());
			pstmt.setInt(3, cartVo.getStock());
			//conn.commit();		
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

	public List<CartVo> getList() {
		List list = new ArrayList<CartVo>();

		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;

		try {

			conn = getConnection();

			// 3. create statement
			stmt = conn.createStatement();

			// 4. run SQL
			String sql = "select c.book_no, b.title, c.stock, b.price "+
							" from book b, cart c "+
							" where b.no = c.book_no ";
							
			rs = stmt.executeQuery(sql); 

			// 5. fetch row( row한개씩 가져오기)
			while (rs.next()) {
				Integer bookNo = rs.getInt(1);
				String bookTitle = rs.getString(2);
				Integer stock = rs.getInt(3);
				Integer price = rs.getInt(4);

				CartVo cartVo = new CartVo();
				cartVo.setBookNo(bookNo);
				cartVo.setBookTitle(bookTitle);
				cartVo.setPrice(price);
				cartVo.setStock(stock);

				list.add(cartVo);
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

	
	public boolean update(CartVo cartVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			
			String sql = "update book set no=?, title =?, price=?, catergoryNo=? where no=?";
			pstmt = conn.prepareStatement(sql);

			/**/

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
