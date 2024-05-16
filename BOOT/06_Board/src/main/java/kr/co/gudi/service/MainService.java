package kr.co.gudi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gudi.dao.MainDAO;
import kr.co.gudi.dto.BoardDTO;

@Service
public class MainService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MainDAO dao;

	public List<BoardDTO> list() {
		return dao.list();
	}
	
}
