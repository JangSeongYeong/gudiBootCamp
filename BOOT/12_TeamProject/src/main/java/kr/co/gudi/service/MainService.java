package kr.co.gudi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gudi.dao.MainDAO;
import kr.co.gudi.dto.TeamDTO;

@Service
public class MainService {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired MainDAO dao;

	public Map<String, Object> listAjax() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TeamDTO> list = dao.list();
		logger.info("list : "+list);

		map.put("list", list);
		return map;
	}

}
