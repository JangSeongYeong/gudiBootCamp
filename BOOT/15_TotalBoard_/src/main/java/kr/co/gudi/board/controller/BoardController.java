package kr.co.gudi.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.gudi.board.dto.BoardDTO;
import kr.co.gudi.board.service.BoardService;

@Controller
public class BoardController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	// 리스트 페이지
	@GetMapping(value="list.go")
	public String list_go(Model model) {
		List<BoardDTO> list = boardService.list();
		model.addAttribute("list", list);
		return "list";
	}
	
	
	// 게시글 작성 페이지
	@GetMapping(value="/write.go")
	public String write_go(Model model) {
		logger.info("게시글 작성 페이지...");
		return "writeForm";
	}
	
	// 게시글 작성
	@PostMapping(value="write.do")
	public ModelAndView write_do(RedirectAttributes rAttr, BoardDTO dto) {
		return boardService.write(rAttr, dto);
	}
	
	
	// 글 수정하기 페이지
	@RequestMapping(value="/update.go")
	public ModelAndView update_go(String idx) {
		return boardService.update_go(idx);
	}
	
	@PostMapping(value="/update.do")
	public ModelAndView update_go(@RequestParam Map<String, String> param) {
		return boardService.update_do(param);
	}
	
	
	// 글 삭제
	@RequestMapping(value="/del.ajax")
	@ResponseBody
	public Map<String, Object> del(@RequestParam(value="delArr[]") List<String> delArr) {
		int cnt = boardService.del(delArr);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cnt", cnt);
		
		return map;
	}
	
	@GetMapping(value="/delete.do")
	public ModelAndView delete(String idx) {
		return boardService.delete_do(idx);
	}
	
	
	// 게시글 상세보기 페이지
	@GetMapping(value="/detail.go")
	public ModelAndView detail(RedirectAttributes rAttr, String bbs_idx) {
		return boardService.detail(rAttr, bbs_idx);
	}

}
