package my.solo.project.board.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import my.solo.project.board.dao.BoardDAO;
import my.solo.project.board.dto.BoardDTO;

@Service
public class BoardService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired BoardDAO boardDAO;
	
	public String file_root = "C:/upload/";
	
	public Map<String, Object> listCall(String page, String cnt) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int currPage = Integer.parseInt(page);
		int pagePerNum = Integer.parseInt(cnt);
		
		int start = (currPage-1) * pagePerNum;
		List<BoardDTO> list = boardDAO.list(start, pagePerNum);
		int totalPages = boardDAO.totalPages(pagePerNum);
		
		logger.info("리스트 유무 : {}", list);
		
		map.put("list", list);
		map.put("currPage", currPage);
		map.put("totalPages", totalPages);
		
		return map;
	}
	
	public Map<String, Object> del(List<String> delList) {
		Map<String, Object> map = new HashMap<String, Object>();
		int row = 0;
		int cnt = 0;
		List<String> photos = null;
		
		for (String delIdx : delList) {
			photos = boardDAO.delPhotos(delIdx);
			logger.info("삭제할 사진 : {}", photos);
			
			row = boardDAO.del(delIdx);
			if (row == 1) {
				cnt++;
				// 사진 삭제
			}
		}
		map.put("cnt", cnt);
		return map;
	}

	public int write(MultipartFile[] photos, Map<String, String> param) {
		int row = 0;
		
		BoardDTO dto = new BoardDTO();
		dto.setSubject(param.get("subject"));
		dto.setUser_name(param.get("user_name"));
		dto.setContent(param.get("content"));
		
		row = boardDAO.write(dto);
		
		int idx = dto.getIdx();
		logger.info("write Data idx : {}", idx);
		
		if (row == 1) {
			fileSave(idx, photos);
		}
		
		return row;
	}

	private void fileSave(int idx, MultipartFile[] photos) {
		for (MultipartFile photo : photos) {
			String ori_filename = photo.getOriginalFilename();
			
			if (!ori_filename.equals("")) {
				String ext = ori_filename.substring(ori_filename.lastIndexOf("."));
				String new_filename = System.currentTimeMillis()+ext;
				logger.info("기존 이름 : {} / 저장용 이름 : {}", ori_filename, new_filename);
				
				
				try {
					Path path = Paths.get(file_root+new_filename);
					Files.write(path, photo.getBytes());
					boardDAO.fileSave(idx, ori_filename, new_filename);
					
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("{} 저장 완료", new_filename);
			}
			
		}
		
	}
	
	
	
}
