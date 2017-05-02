package com.jx372.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.bookmall.vo.CategoryVo;



public class CategoryDao {
	
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
	
	public boolean insert(CategoryVo CategoryVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
						
			String sql = "insert into category values(null,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, CategoryVo.getName());
			
			int count = pstmt.executeUpdate();
			//conn.commit();
			
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

	public List<CategoryVo> getList() {
		List list = new ArrayList<CategoryVo>();

		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;

		try {

			conn = getConnection();

			// 3. create statement
			stmt = conn.createStatement();

			// 4. run SQL
			String sql = "select no, name from category";
			rs = stmt.executeQuery(sql); 
			
			// 5. fetch row( row한개씩 가져오기)
			while (rs.next()) {
				Integer no = rs.getInt(1);
				String name = rs.getString(2);
				
				CategoryVo memberVo = new CategoryVo();
				
				memberVo.setName(name);
				memberVo.setNo(no);
				
				list.add(memberVo);
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


	public boolean update(CategoryVo memberVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			// 3. be ready statement 쿼리를 날리지 않고 default값으로 준비 시켜 놓는다.
			//String sql = "update member set no=?, title =?, price=?, catergoryNo=? where no=?";
			//pstmt = conn.prepareStatement(sql);

//			pstmt.setInt(1, memberVo.getNo());
//			pstmt.setString(2, memberVo.getTitle());
//			pstmt.setInt(3, memberVo.getPrice());
//			pstmt.setInt(4, memberVo.getCategoryNo());

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
