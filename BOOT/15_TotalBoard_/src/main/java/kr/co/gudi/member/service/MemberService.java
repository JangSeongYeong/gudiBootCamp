package kr.co.gudi.member.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.co.gudi.board.dao.BoardDAO;
import kr.co.gudi.board.dto.BoardDTO;
import kr.co.gudi.member.dao.MemberDAO;

@Service
public class MemberService {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberDAO memberDao;
	@Autowired BoardDAO boardDao;
	
	public String login(HttpSession session, Model model, String id, String pw) {
		String msg="아이디 또는 비밀번호를 다시 확인해 주세요...";
		String page= "login";
		
		int row = 0;
		
		row = memberDao.login(id, pw);
		if (row > 0) {
			session.setAttribute("loginId", id);
			msg= id+"님, 환영합니다!";
			page= "list";
			
			List<BoardDTO> list = boardDao.list();
			
			model.addAttribute("loginId", id);
			model.addAttribute("list", list);
		}
		
		return page;
	}

}
