package kr.co.gudi.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.gudi.board.dao.BoardDAO;
import kr.co.gudi.board.dto.BoardDTO;

@Service
public class BoardService {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardDAO boardDao;
	
	public List<BoardDTO> list() {
		return boardDao.list();
	}
	
	
	
	
	public ModelAndView write(RedirectAttributes rAttr, BoardDTO dto) {
		ModelAndView mav = new ModelAndView();
		String msg = "";
		String page = "login";
		boardDao.write(dto);
		int idx = dto.getIdx();
		logger.info("작성된 게시글 번호: "+idx);
		
		if (idx > 0) {
			msg = "게시글이 성공적으로 작성되었습니다...";
			page= "redirect:/detail.go?bbs_idx="+idx;
		} else {
			msg = "게시글 작성에 실패했습니다...";
			page = "redirect:/list.go";
		}
		
		rAttr.addFlashAttribute("msg", msg);
		mav.setViewName(page);
		
		return mav;
	}


	@Transactional
	public ModelAndView detail(RedirectAttributes rAttr, String bbs_idx) {
		ModelAndView mav = new ModelAndView();
		String page = "detail";
		boardDao.upHit(bbs_idx);
		BoardDTO dto = boardDao.detail(bbs_idx);
		mav.addObject("item", dto);
		mav.setViewName(page);
		return mav;
	}
	
	
	
	
	public ModelAndView update_go(String idx) {
		ModelAndView mav = new ModelAndView();
		String page = "list";
		
		page = "updateForm";
		BoardDTO dto = boardDao.detail(idx);
		mav.addObject("item", dto);
		mav.setViewName(page);
		
		return mav;
	}
	public ModelAndView update_do(Map<String, String> param) {
		ModelAndView mav = new ModelAndView();
		
		String page = "list";
		String msg="게시글 수정에 실패 했습니다.";
		
		int row = 0;
		row = boardDao.update(param);
		if (row > 0) {
			page = "list";
			msg = "게시글 수정이 완료 되었습니다.";
		}
		List<BoardDTO> list = boardDao.list();
		mav.addObject("list", list);
		mav.addObject("msg", msg);
		mav.setViewName(page);
		
		return mav;
	}




	public int del(List<String> delArr) {
		int cnt = 0;
		
		for (String idx : delArr) {
			int row = boardDao.del(idx);
			if (row != 0) {
				cnt++;
			}
		}
		
		return cnt;
	}
	public ModelAndView delete_do(String idx) {
		ModelAndView mav = new ModelAndView();
		int row = 0;
		String msg="";
		
		row = boardDao.del(idx);
		if (row != 0) {
			msg="게시글을 삭제하였습니다...";
		}
		
		mav.addObject("msg", msg);
		mav.setViewName("redirect:/list.go");
		
		return mav;
	}

}
