package my.solo.project.member.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.solo.project.member.dao.MemberDAO;
import my.solo.project.member.dto.MemberDTO;

@Service
public class MemberService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired MemberDAO memberDAO;
	
	public int overlay(String id) {
		int row = memberDAO.overlay(id);

		logger.info("server 확인용 return : "+row);
		return row;
	}

	public int join(Map<String, String> map) {
		int row = memberDAO.join(map);
		String perm = map.get("auth");
		if (perm != null && row == 1) {
			memberDAO.grant(map.get("id"), perm);
		}
		return row;
	}

	public MemberDTO login(String id, String pw) {
		return memberDAO.login(id, pw);
	}
	
	
}
