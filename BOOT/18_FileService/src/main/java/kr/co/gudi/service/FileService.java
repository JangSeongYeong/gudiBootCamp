package kr.co.gudi.service;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

import kr.co.gudi.dto.FileDTO;

@Service
public class FileService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Value("${spring.servlet.multipart.location}") private String root;

	public void upload(MultipartFile uploadFile) {
		String fileName = uploadFile.getOriginalFilename();
		
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String newFileName = System.currentTimeMillis() + ext;
		logger.info(fileName+"->"+newFileName); 
		
		try {
			byte[] bytes = uploadFile.getBytes();
			Path path = Paths.get(root+"/"+newFileName);
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void multiUpload(MultipartFile[] files) {
		for (MultipartFile file : files) {
			try {
				upload(file);
				Thread.sleep(1); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<FileDTO> fileList() {
		String[] list = new File(root).list();
		
		List<FileDTO> dtoList = new ArrayList<FileDTO>();
		for (String str : list) {
			FileDTO dto = new FileDTO();
			dto.setFileName(str);
			try {
				String type = Files.probeContentType(Paths.get(root+"/"+str));
				String contentType = type.substring(0, type.lastIndexOf("/"));
				logger.info("type : "+contentType);
				dto.setFileType(contentType);
				dtoList.add(dto);
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		return dtoList;
	}

	public ResponseEntity<Resource> imgView(String fileName) {
		Resource resource = new FileSystemResource(root+"/"+fileName);
		HttpHeaders header = new HttpHeaders();
		
		try {
			String type = Files.probeContentType(Paths.get(root+"/"+fileName)); 
			logger.info("mime-type : "+ type);
			header.add("content-type", type);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK); 
	}

	public void delete(String file) {
		File delFile = new File(root+"/"+file);
		if (delFile.exists()) {
			delFile.delete();
		}
	}
	
	public ResponseEntity<Resource> download(String fileName) {
		Resource resource = new FileSystemResource(root+"/"+fileName);
		HttpHeaders header = new HttpHeaders();
		
		try {
			header.add("content-type", "");
			String oriFile = URLEncoder.encode("이미지_"+fileName, "UTF-8"); 
			header.add("content-Disposition", "attachment;filename=\""+oriFile+"\"");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK); // HttpStatus.OK == 200 (정상 처리)
	}
	
}
