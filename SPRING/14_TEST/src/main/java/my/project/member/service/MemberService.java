package my.project.member.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.project.member.dao.MemberDAO;
import my.project.member.dto.MemberDTO;

@Service
public class MemberService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired MemberDAO dao;
	
	public int join(Map<String, String> map) {
		return dao.join(map);
	}

	public String login(String id, String pw) {
		return dao.login(id, pw);
	}

	public List<MemberDTO> list() {
		return dao.list();
	}

	public MemberDTO detail(String id) {
		return dao.detail(id);
	}

	public void delete(String id) {
		int row = dao.delete(id);
		logger.info("삭제된 데이터 : "+row);
	}

	
	
}
