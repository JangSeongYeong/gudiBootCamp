package com.sprng.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainDAO {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	public Connection conn = null;
	
	public MainDAO() {
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MariaDB");
			conn = ds.getConnection();
			logger.info("connect : "+conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void insert() {
		String sql = "INSERT INTO member(id, pw, name, age, gender, email) VALUES(?,?,?,?,?,?)";
		try {
			conn.setAutoCommit(false); // auto commit 종료 (트랜젝션을 하기 위해서)
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "tester3");
			ps.setString(2, "1234");
			ps.setString(3, "사용자");
			ps.setInt(4, 20);
			ps.setString(5, "여자");
			ps.setString(6, "tester@gmail.com");

			int row = ps.executeUpdate();
			logger.info("영향 받은 데이터의 수 : "+row);
			
			row = ps.executeUpdate();
			logger.info("영향 받은 데이터의 수 : "+row);
			
			conn.commit(); // 완전 성공(마지막까지 완료) 후 커밋
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback(); // 트렌젝션이 동작을 한다는 것은 exception 이 발생했다는 것이기에 catch에서 작업한다.
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
