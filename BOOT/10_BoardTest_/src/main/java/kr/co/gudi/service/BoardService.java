package kr.co.gudi.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.dao.BoardDAO;
import kr.co.gudi.dto.BoardDTO;

@Service
public class BoardService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardDAO dao;

	public List<BoardDTO> list() {
		return dao.list();
	}

	public int login(String id, String pw) {
		return dao.login(id, pw);
	}

	public int write(BoardDTO dto) {
		// 내가 넣은 데이터에 대한 키 값을 받아오기 위한 조건
		// 1. DTO 로 파라메터 사용
		dao.write(dto);
		return dto.getIdx();
	}

	// @Transactional(rollbackFor = Exception.class)
	// 모든 예외에 대해서 롤백처리(기본값)
	// Isolation.READ_COMMITED : (기본값) 다른 트랜잭션에서 커밋된 내용만 읽을 수 있다.
	// Isolation.READ_UNCOMMITED : 다른 트랜잭션에서 커밋되지 않은 데이터도 읽을 수 있다.
	// Isolation.REATABLE_READ : 조회중인 데이터를 다른 트랜잭션에서 UPDATE 못하도록 막는다.
	// Isolation.SERIALIZABLE : 한 트랜잭션 내용이 커밋될때 까지 다른 트랜잭션은 CRUD 불가
	
	
	@Transactional(isolation = Isolation.DEFAULT)
	public ModelAndView detail(String idx, HttpSession session) {
		
		// @Transactional 사용시 try-catch 를 사용하면 자동 롤백이 되지 않는다.
		// 그래서 예외 처리를 web.xml 을 통해서 특정 에러나 에러코드 발생시 특정한 요청이나 페이지로 보내는 방식을 사용한다.
		// 그런데 BOOT 는 web.xml 이 존재하지 않는다.
		// BOOT 에서는 ErrorController Interface 를 활용한다.
		
		
		ModelAndView mav = new ModelAndView();
		String page = "login";
		String msg = "로그인이 필요한 서비스입니다.";
		
		if (session.getAttribute("loginId") != null) {
			page = "detail";
			dao.upHit(idx);
			BoardDTO dto = dao.detail(idx);
			mav.addObject("dto", dto);
		} else {
			mav.addObject("msg", msg);
		}
		mav.setViewName(page);
		return mav;
	}
	

	

	
}
