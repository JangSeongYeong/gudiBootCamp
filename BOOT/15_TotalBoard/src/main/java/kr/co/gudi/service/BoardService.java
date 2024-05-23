package kr.co.gudi.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.gudi.dao.BoardDAO;
import kr.co.gudi.dto.BoardDTO;

@Service
public class BoardService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	private final BoardDAO boardDAO;
	
	public BoardService(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	

	public ModelAndView list(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String page = "login";
		
		if (session.getAttribute("loginInfo") != null) {
			List<BoardDTO> list = boardDAO.list();
			
			mav.addObject("list", list);
			page = "list";
		} else {
			mav.addObject("msg", "로그인이 필요한 서비스 입니다.");
		}
		mav.setViewName(page);
			
		return mav;
	}

	public ModelAndView write(HttpSession session, BoardDTO dto, RedirectAttributes rAttr) {
		ModelAndView mav = new ModelAndView();
		String page = "redirect:list";
		
		if (session.getAttribute("loginInfo") != null) {
			int idx = boardDAO.write(dto);
			if (idx == 1) {
				page = "redirect:/detail.go?idx="+dto.getIdx();
				rAttr.addFlashAttribute("msg", "글 작성에 성공했습니다.");
			}
		} 
		
		mav.setViewName(page);
		
		return mav;
	}

	@Transactional(rollbackFor = Exception.class)
	public ModelAndView detail(HttpSession session, String idx) {
		ModelAndView mav = new ModelAndView("detail");
		
		if (session.getAttribute("loginInfo") != null) {
			boardDAO.upHit(idx);
			BoardDTO dto = boardDAO.detail(idx);
			mav.addObject("bbs", dto);
		} else {
			mav.setViewName("redirect:list");
		}
		return mav;
	}

	public ModelAndView updateGo(HttpSession session, String idx) {
		ModelAndView mav = new ModelAndView("updateForm");
		
		if (session.getAttribute("loginInfo") != null) {
			BoardDTO dto = boardDAO.detail(idx);
			mav.addObject("bbs", dto);
		} else {
			mav.setViewName("redirect:list");
		}
		
		return mav;
	}

	public ModelAndView delete(HttpSession session, String idx, RedirectAttributes rAttr) {
		ModelAndView mav = new ModelAndView("redirect:/list");
		
		if (session.getAttribute("loginInfo") != null) {
			int row = boardDAO.delete(idx);
			String msg = "글번호 "+idx+" 삭제 ";
			if (row == 1) {
				msg += "성공";
			} else {
				msg += "실패";
			}
			rAttr.addFlashAttribute("msg", msg);
		} 
		
		return mav;
	}

	public ModelAndView update(HttpSession session, Map<String, String> params) {
		ModelAndView mav = new ModelAndView("redirect:/detail.go?idx="+params.get("idx"));
		
		if (session.getAttribute("loginInfo") != null) {
			boardDAO.update(params);
		} else {
			mav.setViewName("redirect:list");
		}
		return mav;
	}
	
	
	
	
}
