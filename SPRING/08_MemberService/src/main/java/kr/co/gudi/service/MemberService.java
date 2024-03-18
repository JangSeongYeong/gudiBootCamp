package kr.co.gudi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.gudi.dao.MemberDAO;
import kr.co.gudi.dto.MemberDTO;

public class MemberService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	// DAO 에게 회원정보를 넣으라는 매서드
	public int join(String id, String pw, String name, String age, String gender, String email) {
		logger.info("service join 진입");
		MemberDAO dao = new MemberDAO();
		return dao.join(id, pw, name, age, gender, email);
		
	}

	public boolean login(String id, String pw) {
		MemberDAO dao = new MemberDAO();
		return dao.login(id,pw);
	}

	public List<MemberDTO> list() {
		MemberDAO dao = new MemberDAO();
		return dao.list();
	}

	public MemberDTO detail(String id) {
		logger.info("service detail 진입");
		MemberDAO dao = new MemberDAO();
		return dao.detail(id);
	}

	public void delete(String id) {
		logger.info("service del 진입");
		MemberDAO dao = new MemberDAO();
		dao.delete(id);
	}

}
