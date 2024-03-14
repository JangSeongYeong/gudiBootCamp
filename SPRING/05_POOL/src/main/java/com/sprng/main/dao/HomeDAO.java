package com.sprng.main.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomeDAO {

	private static final Logger logger = LoggerFactory.getLogger(HomeDAO.class);
	
	public boolean dbConnect() {
		logger.info("DAO home 접근");
		boolean success = false;
		
		// 1. 접속 정보
		String id = "web_user";
		String pw = "pass";
		String url = "jdbc:mariadb://localhost:3306/mydb";
		String drive = "org.mariadb.jdbc.Driver";
		
		try {
			// 2. 드라이버 매니저 불러오기
			Class.forName(drive);
			// 3. connection 가져오기.
			Connection conn = DriverManager.getConnection(url, id,pw); // Driver 매니저는 java.sql객체 
			// org.mariadb.jdbc.MariaDbConnection@b792c34
			logger.info("conn : "+conn);
			
			// 4. 작업 (생략)
			if(conn != null) {
				success = true;
				// 5. 커넥션 반납
				conn.close();
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("성공 실패 여부 : "+success);
		return success;
	}

	/*
	 <Resource
    	name="jdbc/MariaDB" <- 호출할 이름
    	auth="Container" <- 제어를 누가 하게 할것인가?(톰캣|Spring|개발자)
    	type="javax.sql.DataSource" <- xml의 태그를 자바의 어떤 데이터 타입으로 변경할 것인가?
    	driverClassName="org.mariadb.jdbc.Driver" <- 밑에 4개는 DB에 접속할 때 사용
    	url="jdbc:mariadb://localhost:3306/mydb"
    	username="web_user"
    	password="pass"
    /> 
	*/
	
	public boolean poolConnect() {
		boolean success = false;
		try {
			// 1. context.xml 을 자바 객체로 변환
			Context ctx = new InitialContext();
			// 2. Resource 태그를 이름을 사용해서 찾아온다. -> java 형태로 변환한다.
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MariaDB"); // comp 는 컴파일의 약자
			// 자바 컴파일 환경에서 사용하기 위해서 추가
			// 3. 커넥션을 불러 온다.
			Connection conn = ds.getConnection();
			logger.info("pool connection : "+conn);
			
			if (conn != null) {
				success = true;
				conn.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return success;
	}
	
	
}
