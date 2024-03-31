package kr.co.photo.board.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.photo.board.dao.BoardDAO;
import kr.co.photo.board.dto.BoardDTO;

@Service
public class BoardService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardDAO dao;
	
	String upload_root = "C:/upload/";
	
	public List<BoardDTO> list() {
		logger.info("dao list call");
		return dao.list();
	}

	public String write(Map<String, String> params, MultipartFile[] photos) {
		// 1. 글쓰기
		BoardDTO dto = new BoardDTO();
		dto.setSubject(params.get("subject"));
		dto.setSubject(params.get("user_name"));
		dto.setSubject(params.get("content"));
		
		String page = "redirect:/write.go";
		if(dao.write(dto) > 0) {
			// 2. 방금 쓴 글의 idx 추출
			int idx = dto.getIdx();
			// 3. 파일 저장 + 저장 정보 DB 에 저장
			fileSave(idx, photos);
			page = "redirect:/detail?idx="+idx;
		}
		
		return page;
	}

	private void fileSave(int idx, MultipartFile[] photos) {

		for (MultipartFile photo : photos) {
			// 1. 원래 이름 추출
			String oriFileName = photo.getOriginalFilename();
			
			// 2. 확장자를 떼내서 새로운 이름 추출
			String ext = oriFileName.substring(oriFileName.lastIndexOf("."));
			String newFileName = System.currentTimeMillis()+ext;
			
			// 3. 파일 저장
			try {
				Path path = Paths.get(upload_root+newFileName);
				Files.write(path, photo.getBytes());
				// 4. DB 에 저장
				dao.writePhoto(idx, oriFileName, newFileName);
				
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
			
		}
		
	}

}
