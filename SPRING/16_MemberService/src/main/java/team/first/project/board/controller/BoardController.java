package team.first.project.board.controller;

import java.util.HashMap;
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

import team.first.project.board.dto.BoardDTO;
import team.first.project.board.service.BoardService;

@Controller
public class BoardController {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired BoardService boardService;
	
	@RequestMapping(value = "/list.ajax")
	@ResponseBody
	public Map<String, Object> listCall(){
		Map<String, Object> map = new HashMap<String, Object>(); 
		List<BoardDTO> list = boardService.listCall();
		map.put("list", list);
		
		return map;
	}
	
	@RequestMapping(value = "/del.ajax", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> del(@RequestParam (value="delList[]") List<String> delList){
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("cnt", boardService.del(delList));
		return map;
	}
	
	
}
