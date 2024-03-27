package team.first.project.member.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.first.project.member.dao.MemberDAO;
import team.first.project.member.dto.MemberDTO;

@Service
public class MemberService {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired MemberDAO memberDAO;
	
	public int overlay(String id) {
		return memberDAO.overlay(id);
	}

	public int join(Map<String, String> param) {
		int row = memberDAO.join(param);
		String perm = param.get("auth");
		logger.info("perm : "+perm);
		if(perm != null) {
			memberDAO.setPermission(param.get("id"), perm);
		}
		return row;
	}

	public MemberDTO login(String id, String pw) {
		return memberDAO.login(id, pw);
	}

	
}
