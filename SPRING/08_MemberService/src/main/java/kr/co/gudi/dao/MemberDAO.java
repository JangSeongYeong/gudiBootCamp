package kr.co.gudi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberDAO {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	Connection conn = null;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MariaDB");
			conn = ds.getConnection();
			logger.info("conn : "+conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원 정보 넣는 매서드
	public int join(String id, String pw, String name, String age, String gender, String email) {
		logger.info("join 시작");
		int row = -1;
		// sql 준비
		String sql = "insert into member(id,pw,name,age,gender,email) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql); // 실행 객체 생성
			// ? 값 넣기
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setInt(4, Integer.parseInt(age));
			ps.setString(5, gender);
			ps.setString(6, email);
			
			row = ps.executeUpdate(); // 실행
			logger.info("insert 완료");
			
			ps.close(); // 자원 반납
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row; // 값 반환
	}

	public boolean login(String id, String pw) {
		
		boolean success = false;
		
		// 1. 쿼리문 준비
		String sql = "select id from member where id = ? and pw = ?";
		try {
			// 2. 실행 객체 준비
			PreparedStatement ps = conn.prepareStatement(sql);
			// 2-1. ? 대입
			ps.setString(1, id);
			ps.setString(2, pw);
			// 3. 실행
			ResultSet rs = ps.executeQuery();
			// 4. 값 꺼내기
			success = rs.next();
			// 5. 자원 반납
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	public void list() {
		
		// 1. 쿼리문 중비
		String sql = "SELECT id, name, age, email FROM member";
		try {
			// 2. 실행 객체 준비
			PreparedStatement ps = conn.prepareStatement(sql);
			// 3. 실행
 			ResultSet rs = ps.executeQuery();
 			while (rs.next()) { // 4. 데이터 가져오기
 				String id = rs.getString("id");
 				String name = rs.getString("name");
 				int age = rs.getInt("age");
 				String email = rs.getString("email");
 				logger.info(id+" "+name+" "+age+" "+email);
			}
			// 5. 자원 반납
 			rs.close();
 			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
