package our.first.project.member.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import our.first.project.member.dao.MemberDAO;
import our.first.project.member.dto.MemberDTO;

@Service
public class MemberService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired MemberDAO dao;
	
	
	public String login(String id, String pw) {
		return dao.login(id, pw);
	}


	public List<MemberDTO> memberList() {
		return dao.memberList();
	}


	public int join(Map<String, String> param) {
		return dao.join(param);
	}

}
