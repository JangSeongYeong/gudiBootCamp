package kr.co.gudi.dao;

// xml 을 사용하기 위한 중간다리 역할만 함
public interface MemberDAO {

	int join(String id, String pw, String name, String age, String gender, String email);
	
}
