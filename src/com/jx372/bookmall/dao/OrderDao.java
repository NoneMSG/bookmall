package com.jx372.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jx372.bookmall.vo.OrderVo;

public class OrderDao {
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
	
	public boolean insert(OrderVo orderVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			
			
			String sql = "insert into orders values(null,(select no from member where no=?),?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderVo.getMemberNo());
			pstmt.setInt(2, orderVo.getOrderPrice());
			pstmt.setString(3, orderVo.getAddress());
				
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

	public List<OrderVo> getList() {
		List list = new ArrayList<OrderVo>();

		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;

		try {

			conn = getConnection();

			// 3. create statement
			stmt = conn.createStatement();

			// 4. run SQL
			String sql = "select o.no, m.name, m.email, (b.price*c.stock)as total, o.address"+
						" from member m, book b, orders o, cart c"+
						" where m.no=o.mem_no"+
						" and c.book_no = b.no"+
						" and c.mem_no = m.no";
			rs = stmt.executeQuery(sql); 

			// 5. fetch row( row한개씩 가져오기)
			while (rs.next()) {
				
				Integer orderNo = rs.getInt(1);
				String memberName = rs.getString(2);
				String email = rs.getString(3);
				Integer orderPrice = rs.getInt(4);
				String address = rs.getString(5);

				OrderVo orderVo = new OrderVo();
				orderVo.setNo(orderNo);
				orderVo.setMemberName(memberName);
				orderVo.setEmail(email);
				orderVo.setOrderPrice(orderPrice);
				orderVo.setAddress(address);
				
				list.add(orderVo);
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

	
	public boolean update(OrderVo orderVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			// 3. be ready statement 쿼리를 날리지 않고 default값으로 준비 시켜 놓는다.
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
