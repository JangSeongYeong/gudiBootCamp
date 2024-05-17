package kr.co.gudi.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.dao.MemberDAO;
import kr.co.gudi.dto.MemberDTO;

@Service
public class MemberService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberDAO memberDAO;

	public ModelAndView join(MemberDTO dto) {
		
		int row = memberDAO.join(dto);
		logger.info("insert row = "+row);
		
		String msg = "회원 가입에 실패 했습니다.";
		String page = "joinForm";
		
		if (row > 0) {
			msg = "회원 가입에 성공 했습니다.";
			page = "result";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName(page);
		
		return mav;
	}

	public ModelAndView list(Map<String, String> params) {
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> list = memberDAO.list(params);
		
		String msg = params.get("keyword")+"에 대한 검색 결과가 ";
		
		if (list != null && list.size() > 0) {
			logger.info("size : ", list.size());
			msg += list.size()+" 건 있습니다.";
		} else {
			msg += "없습니다.";
		}
		
		logger.info(msg);
		
		mav.addObject("msg", msg);
		mav.addObject("list", list);
		mav.setViewName("list");
		
		
		return mav;
	}
	
	
	
}
