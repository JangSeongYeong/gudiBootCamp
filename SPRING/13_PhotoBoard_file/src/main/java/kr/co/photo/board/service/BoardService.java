package kr.co.photo.board.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import kr.co.photo.board.dao.BoardDAO;
import kr.co.photo.board.dto.BoardDTO;
import kr.co.photo.board.dto.PhotoDTO;

@Service
public class BoardService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardDAO dao;

	// 사진불러오기시 server.xml 에 아래 내용 추가해야 함
	// <Context docBase="C:/upload" path="/photo"/>
	public String file_root = "C:/upload/"; // '/' 여부 주의
	
	public List<BoardDTO> list() {
		return dao.list();
	}

	public void delete(String idx) {
		// 1. idx 에 해당하는 newFileName 값들 가져오기
		String[] delFiles = dao.delFileList(idx);
		logger.info("delFile : "+Arrays.toString(delFiles));
		
		int row = -1;
		row = dao.delete(idx);
		logger.info("delete row : "+row);
		
		if (row > 0) {
			// 2. 경로에 맞춰서 데이터 삭제
			for (String dfile : delFiles) {
				Path path = Paths.get(file_root+dfile); // 저장 경로 지정
				logger.info("Path" +path);
				try {
					Files.delete(path);
				} catch (IOException e) {
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

	public int write(MultipartFile[] photos, Map<String, String> map) {
		int row = -1;
		// insert 후 생성된 idx 가져오는 방법
		// 조건 1. 파라메터는 DTO 로 넣을 것
		BoardDTO dto = new BoardDTO();
		dto.setUser_name(map.get("user_name"));
		dto.setSubject(map.get("subject"));
		dto.setContent(map.get("content"));
		// 조건 2. mapper에
		row = dao.write(dto); // 글쓰기 완료후
		// 조건 3. 이후 dto 에서 저장된 키 값을 받아온다.
		int idx = dto.getIdx();
		logger.info("insert idx = "+idx);
		if (row > 0) {
			fileSave(idx, photos); // 파일저장			
		}
		
		return row;
	}
	
	private void fileSave(int idx, MultipartFile[] photos) {
		
		for (MultipartFile photo : photos) {
			// 1. 업로드 할 파일명이 있는가? | 있으면 이름, 없으면 ""(공백)
			String fileName = photo.getOriginalFilename();
			logger.info("file Name : "+fileName);
			if (!fileName.equals("")) { // 파일명이 있다면 == 업로드 파일이 있다면
				// 1. 기존 파일명에서 확장자 추출 (high.gif)
				/* 1-1 split 활용 방법
				String[] fileNameSplit = fileName.split("\\.");
				String ext = "."+fileNameSplit[fileNameSplit.length-1];
				 */
				
				// 1-2. subString 활용 방법
				String ext = fileName.substring(fileName.lastIndexOf("."));
				
				// 2. 새파일명 생성 (서버에 저장된 이름의 중복 방지하기 위해서 ms단위의 시간을 뽑아 이름으로 넣는다.) 
				String newFileName = System.currentTimeMillis()+ext;
				logger.info(fileName+"->"+newFileName);
				
				// 3. 파일 저장
				try {
					byte[] bytes = photo.getBytes(); // MultipartFile 로 부터 바이너리 추출
					Path path = Paths.get(file_root+newFileName); // 저장 경로 지정
					Files.write(path, bytes);// 저장  // write는 경로 바이트 옵션이 필요한데 옵션은 필수가 아니다.
					dao.fileWrite(fileName, newFileName, idx);
					Thread.sleep(1); // 파일 업로드시 너무 작아서 1ms 도 안걸려서 이름이 겹치는 것을 방지 - 파일명을 위해 강제 휴식 부여 
				} catch (Exception e) { // exception이 파일정보 받아오는 과정에서 한번 ,쓰레드에서 한번 있어서 다형성 활용
					e.printStackTrace();
				}
			}
		}
		
	}

	public void updateForm(String idx, Model model) {
		BoardDTO dto = dao.detail(idx);
		model.addAttribute("bbs", dto);
		
		List<PhotoDTO> list = dao.photos(idx);
		logger.info("list : {}", list);
		model.addAttribute("photos", list);

	}

	public void update(MultipartFile[] photos, Map<String, String> map) {	
		int row = dao.update(map);
		logger.info("수정한 row : "+row);
		if (row > 0) {
			fileSave(Integer.parseInt(map.get("idx")), photos); 			
		}
	}

}
