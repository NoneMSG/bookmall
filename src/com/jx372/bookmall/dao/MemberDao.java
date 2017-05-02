package com.jx372.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.bookmall.vo.MemberVo;

public class MemberDao {
	
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
	
	public boolean insert(MemberVo memberVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
						
			String sql = "insert into member values(null,?,?,?,password(?))";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2, memberVo.getPhone());
			pstmt.setString(3, memberVo.getEmail());
			pstmt.setString(4, memberVo.getPw());
		
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

	public List<MemberVo> getList() {
		List list = new ArrayList<MemberVo>();

		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;

		try {

			conn = getConnection();

			// 3. create statement
			stmt = conn.createStatement();

			// 4. run SQL
			String sql = "select  no as ' ', name as ' ', phone as ' ', email as ' ', pw as ' ' from member";
			rs = stmt.executeQuery(sql); 
			
			// 5. fetch row( row한개씩 가져오기)
			while (rs.next()) {
				Integer no = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String pw = rs.getString(5);

				MemberVo memberVo = new MemberVo();
				
				memberVo.setName(name);
				memberVo.setNo(no);
				memberVo.setPhone(phone);
				memberVo.setPw(pw);
				memberVo.setEmail(email);
				
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


	public boolean update(MemberVo memberVo) {
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
