package kr.co.gudi.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.dao.MemberDAO;
import kr.co.gudi.dto.MemberDTO;

@Service
public class MemberService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	private final MemberDAO memberDAO;
	
	public MemberService(MemberDAO memberDAO) {
		this.memberDAO= memberDAO;
	}
	
	public ModelAndView login(HttpSession session, Map<String, String> params) {
		ModelAndView mav = new ModelAndView();
		String page = "login";
		
		MemberDTO dto = memberDAO.login(params);
		
		if (dto != null) {
			session.setAttribute("loginInfo", dto);
			page = "redirect:list";
		} else {
			mav.addObject("msg", "로그인 실패");			
		}
		
		mav.setViewName(page);
		
		return mav;
	}
	
	
}
