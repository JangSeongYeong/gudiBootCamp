package our.first.project.board.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import our.first.project.board.dao.BoardDAO;
import our.first.project.board.dto.BoardDTO;
import our.first.project.board.dto.PhotoDTO;

@Service
public class BoardService {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired BoardDAO dao;
	
	public String file_root = "C:/upload/";

	public List<BoardDTO> list() {
		return dao.list();
	}

	public int write(MultipartFile[] photos, Map<String, String> param) {
		int row = -1;
		// index 가져오기
		BoardDTO dto = new BoardDTO();
		dto.setUser_name(param.get("user_name"));
		dto.setSubject(param.get("subject"));
		dto.setContent(param.get("content"));
		
		row = dao.write(dto);
		int idx = dto.getIdx();
		logger.info("insert idx : "+idx);
		if(row > 0) {
			fileSave(idx, photos);
		}
		
		return row;
	}

	private void fileSave(int idx, MultipartFile[] photos) {

		for (MultipartFile photo : photos) {
			String fileName = photo.getOriginalFilename();
			logger.info("fileName : "+fileName);
			
			if (!fileName.equals("")) {
				// 1. 확장자 추출 및 이름 생성
				String ext = fileName.substring(fileName.lastIndexOf("."));
				
				String newFileName = System.currentTimeMillis()+ext;
				logger.info("newFlieName : "+newFileName);
				// 2. 파일 저장
				try {
					byte[] bytes = photo.getBytes();
					Path path = Paths.get(file_root+newFileName);
					Files.write(path, bytes);
					dao.fileWrite(fileName, newFileName, idx);
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}

	public void detail(String idx, Model model) {
		dao.upHit(idx); // upHit
		BoardDTO dto = dao.detail(idx);
		model.addAttribute("bbs", dto);
		
		List<PhotoDTO> list = dao.photos(idx);
		logger.info("list : {}", list);
		model.addAttribute("photos", list);
	}

	public void updateForm(String idx, Model model) {
		BoardDTO dto = dao.detail(idx);
		model.addAttribute("bbs", dto);
		
		List<PhotoDTO> list = dao.photos(idx);
		logger.info("list : {}", list);
		model.addAttribute("photos", list);
	}
	
}
