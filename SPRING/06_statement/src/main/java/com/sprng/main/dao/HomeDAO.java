package com.sprng.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomeDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeDAO.class);	
	Connection conn = null; // class에서 사용해야 하기에 밖으로 빼기 
	
	// DAO를 객체화 한다는 것은 DB에 접속한다는 것이므로 생성자를 통해서 미리 DB 접속
	public HomeDAO() {
		try {
			// 1. context.xml java 객체화
			Context ctx = new InitialContext();
			// 2. 이름으로 Resource 태그를 찾아서 Object를 DataSource 로 변환 (자바 컴파일 환경에서 사용)
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MariaDB");
			// 3. DataSource로 Connection 가져오기
			conn = ds.getConnection();
			logger.info("connection : "+conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean createTable() throws SQLException {
		boolean success = false;
		
		// 1. 쿼리문을 준비 (쿼리문의 ; 은 반드시 빼줘야 한다.)
		String sql = "create table member("
				+ "	ID varchar(50) primary key"
				+ "	,PW varchar(100)"
				+ "	,NAME varchar(50)"
				+ "	,AGE int(4)"
				+ "	,GENDER varchar(4)"
				+ "	,EMAIL varchar(100)"
				+ ")";
		
		// 2. 실행할 객체 준비 (Statement | PreparedStatement)
		Statement stmt = conn.createStatement(); // java.sql의 Statement
		
		// 3. 쿼리문 실행(executeQuery | executeUpdate) - select 만 executeQuery
		int row = stmt.executeUpdate(sql);
		logger.info("영향받은 데이터 수 : "+row);
		success = true;
		
		stmt.close(); // stmt 도 close 필요
		conn.close();
		
		return success;
	}

	public int insert(String id, String pw, String name, String age, String gender, String email) {
		
		int row = -1; // 바뀐게 없을 수도 있기에 실패했을 때 -1
		// 1. 쿼리문 준비
		String sql = "insert into member(id,pw,name,age,gender,email) values(?,?,?,?,?,?)"; // 어떤 값이 들어갈지는 모른다. PreparedStatement는 ?를 수정함으로 변경
		try {
			// 2. 실행 객체 생성(Statement | PreparedStatement) 
			PreparedStatement ps = conn.prepareStatement(sql);
			// 2-1. ? 대입
			ps.setString(1, id); // 첫 번재 문자열에는 id값이 들어간다.
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setInt(4, Integer.parseInt(age));
			ps.setString(5, gender);
			ps.setString(6, email);
			
			
			// 3. 쿼리 실행 (executeQuery | executeUpdate) + 결과값 받기
			row = ps.executeUpdate();
			// 4. 자원 정리
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public void list() {
		
		// 1. 쿼리문 준비
		String sql = "select * from member";
		try {
			// 2. 실행 객체 준비
			PreparedStatement ps = conn.prepareStatement(sql);
			// 2-1. ? 가 있으면 대입 -> ? 없으니 생략
			// 3. 쿼리 실행
			ResultSet rs = ps.executeQuery(); // 결과를 ResultSet으로 반환 java.sql
			
			while (rs.next()) {
				// 4. 값 가져오기
				logger.info("id : {}", rs.getString("id")); // getString 인자값 columm label을 이용
				logger.info("pw : {}", rs.getString(2)); // getString 인자값 cloumm index을 이용
				logger.info("name : {}", rs.getString("name"));
				logger.info("age : {}", rs.getInt("age"));
				logger.info("gender : {}", rs.getString("gender"));
				logger.info("email : {}", rs.getString("email"));
				logger.info("=================");
			}
			
			// 5. 자원정리
			ps.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	
	
}
