package my.solo.project.board.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import my.solo.project.board.service.BoardService;

@Controller
public class BoardController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired BoardService boardService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "list";
	}
	
	
	// list 불러오기
	@RequestMapping(value = "/list.ajax", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listCall(String page, String cnt){
		logger.info("============================");
		logger.info("현재 페이지 : {} / 화면에 보여줄 페이지 갯수 : {}", page, cnt);
		Map<String, Object> map = boardService.listCall(page, cnt);
		
		return map;
	}
	
	// 글 삭제
	@RequestMapping(value = "/del.ajax", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> del(@RequestParam (value="delList[]") List<String> delList ){
		logger.info("삭제할 리스트 : {}", delList);
		Map<String, Object> map = boardService.del(delList);
		return map;
	}
	
	// 글 쓰기 폼으로 이동
	@RequestMapping(value = "/write.go", method = RequestMethod.GET)
	public String writeGo() {
		return "writeForm";
	}
	
	// 글 쓰기
	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String writeDo(MultipartFile[] photos, @RequestParam Map<String, String> param) {
		logger.info("writeData : {}, {}", param, photos);
		String page = "writeForm";
		
		int row = boardService.write(photos, param);
		if (row == 1) {
			page = "redirect:/list";
		}
		return page;
	}
	
	// 글 자세히
	
	
	// 글 수정
	
	
	
}
