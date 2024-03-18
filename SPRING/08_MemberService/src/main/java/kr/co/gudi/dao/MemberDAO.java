package kr.co.gudi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.gudi.dto.MemberDTO;

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

	public List<MemberDTO> list() {
		
		// 1. 쿼리문 준비
		String sql = "SELECT id, name, age, email FROM member";
		List<MemberDTO> list = new ArrayList<MemberDTO>(); // catch에 걸렸을때 대비로 위에 뺴기
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
 				// logger.info(id+" "+name+" "+age+" "+email);
 				MemberDTO dto = new MemberDTO(id, name, age, email);
 				list.add(dto);
			}
			// 5. 자원 반납
 			rs.close();
 			ps.close();
 			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public MemberDTO detail(String id) {
		logger.info("DAO detail 진입");

		String sql = "SELECT id, pw, name, age, gender, email FROM member WHERE id = ?";
		MemberDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				String mem_id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String email =rs.getString("email");

				logger.info(mem_id+" "+pw+" "+name+" "+age+" "+gender+" "+email);
				
				dto = new MemberDTO(mem_id, pw, name, age, gender, email);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public void delete(String id) {
		logger.info("DAO del 진입");
		String sql = "DELETE FROM member WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int row = ps.executeUpdate();
			logger.info("지운 갯수 : "+row);
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
