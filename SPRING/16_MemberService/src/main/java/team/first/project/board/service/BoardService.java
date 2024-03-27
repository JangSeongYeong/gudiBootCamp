package team.first.project.board.service;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.first.project.board.dao.BoardDAO;
import team.first.project.board.dto.BoardDTO;

@Service
public class BoardService {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired BoardDAO boardDAO;
	public String file_root = "C:/upload/";
	
	public List<BoardDTO> listCall() {
		return boardDAO.listCall();
	}

	public int del(List<String> delList) {
		int cnt = 0;
		
		for (String idx : delList) {
			List<String> fileList = boardDAO.fileList(idx);
			logger.info("del Files : {}", fileList);
			cnt += boardDAO.del(idx);
			fileDel(fileList);
		}
		
		return cnt;
	}

	private void fileDel(List<String> fileList) {
		for (String file : fileList) {
			File photo = new File(file_root+file);
			if (photo.exists()) {
				photo.delete();
				logger.info(file+" 삭제");
			}
		}
	}

	
	

	
	
}
