package kr.co.gudi.service;

import java.io.File;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${spring.servlet.multipart.location}")	
	private String root;
	
	public List<Map<String, String>> getList() {
		List<Map<String, String>> fileList = new ArrayList<Map<String,String>>();
		
		try {
			for (String fileName : new File(root).list()) {
				Map<String, String> map = new HashMap<String, String>();
				String type = Files.probeContentType(Paths.get(root+"/"+fileName));
				map.put("name", fileName);
				
				// type 이 null 이 아니고 image 를 포함하고 있으면 "true"
				if (type != null && type.contains("image")) {
					map.put("image", "true");
				} else {
					map.put("image", "false");
				}
				
				fileList.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("fileList : {}", fileList);
		
		return fileList;
	}
		
	public void upload(MultipartFile file) {
		String orgName = file.getOriginalFilename();
		String ext = orgName.substring(orgName.lastIndexOf("."));
		String newName = System.currentTimeMillis()+ext;
		logger.info(orgName+" -> "+newName);
		
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(root+"/"+newName);
			Files.write(path, bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 다중 파일 업로드
	public void multiUpload(MultipartFile[] files) {
		
		for (MultipartFile file : files) {
			try {
				upload(file);
				Thread.sleep(1);	//1ms 업로드 지연
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	// 이미지 보기
	public ResponseEntity<Resource> imgView(String fileName) {
		// 특정 경로에서 파일을 읽어 resource 생성
		Resource resource = new FileSystemResource(root+"/"+fileName);
		HttpHeaders header = new HttpHeaders();

		// 보낼 파일 형태 지정(in header)
		// ex) image/gif, image/png 등
		try {
			String type = Files.probeContentType(Paths.get(root+"/"+fileName));
			logger.info("mine-type"+type);
			header.add("content-type", type);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 보낼 내용+헤더+상태
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	*/

	// 파일 삭제
	public void delete(String file) {
		File delFile = new File(root+"/"+file);
		if(delFile.exists()) {
			delFile.delete();
		}
	}

	// 다운로드
	public ResponseEntity<Resource> download(String fileName) {
		// 특정 경로에서 파일을 읽어 resource 생성
		Resource resource = new FileSystemResource(root+"/"+fileName);
		HttpHeaders header = new HttpHeaders();

		try {
			String type = Files.probeContentType(Paths.get(root+"/"+fileName));
			logger.info("mine-type"+type);
			// content-type: image,text,binary,...
			// application/octet-stream = binary
			header.add("content-type", "application/octet-stream");

			// content-Disposition: 추출하려는 컨텐트 형태(inline:문자열, attachment:다운 파일)
			// 단, 한글일 경우 깨짐 -> encoding 필요
			String oriFile = URLEncoder.encode("이미지_"+fileName, "UTF-8");
			header.add("content-Disposition", "attachment;filename=\""+oriFile+"\"");
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 보낼 내용+헤더+상태
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	


}
