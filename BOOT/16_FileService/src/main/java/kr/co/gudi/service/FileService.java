package kr.co.gudi.service;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
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

@Service
public class FileService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${spring.servlet.multipart.location}") private String root;

	public void upload(MultipartFile file) {
		// 1. 파일명 추출
		String fileName = file.getOriginalFilename();
		
		// 2. 새 파일명 생성
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String newFileName = System.currentTimeMillis() + ext;
		logger.info(fileName+"->"+newFileName); 
		
		// 3. 파일 저장
		try {
			byte[] bytes = file.getBytes();
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
				Thread.sleep(1); // 1ms 단위로 업로드를 하도록 지연시킴 (나중에는 해쉬코드로 사용함)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public List<String> fileList() {
		
		// File file = new File(root);
		String[] list = new File(root).list();
		
		return Arrays.asList(list);
	}

	public ResponseEntity<Resource> imgView(String fileName) {
		
		// 1. 특정 경로에서 파일을 읽어와 Resource 로 만든다.
		Resource resource = new FileSystemResource(root+"/"+fileName);
		HttpHeaders header = new HttpHeaders();
		
		// 2. 보내질 파일의 형태를 지정해 준다.
		// 예 : image/gif, image/png, image/jpg, image/jpeg
		try {
			String type = Files.probeContentType(Paths.get(root+"/"+fileName)); // 경로를 주면 해당 파일의 mime-type을 알아낸다.
			logger.info("mime-type : "+ type);
			header.add("content-type", type);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		// 보낼 내용, 헤더, 상태(200 또는 HttpStatus.OK 는 정상이라는 뜻)
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK); // HttpStatus.OK == 200 (정상 처리)
	}

	public void delete(String file) {
		File delFile = new File(root+"/"+file);
		if (delFile.exists()) {
			delFile.delete();
		}
	}

	public ResponseEntity<Resource> download(String fileName) {
		// 특정 경로에서 파일을 읽어와 Resource 로 만든다.
		Resource resource = new FileSystemResource(root+"/"+fileName);
		HttpHeaders header = new HttpHeaders();
		
		try {
			// image/...은 이미지, text/...는 문자열, application/octet-stream 는 바이너리
			header.add("content-type", ""); // content-type
			// 보낼 파일 이름
			// content-Disposition 는 내다 보내려는 컨텐트의 형태를 의미한다. inline 이면 문자열, attachment 는 다운로드 파일을 의미
			// attachment;filename="fileName.jsp"
			// 이때 파일명이 한글일 경우 꺠져서 다운로드 된다. 그래서 안전하게 인코딩 해 준다.
			String oriFile = URLEncoder.encode("이미지_"+fileName, "UTF-8"); // 이 인코딩 과정이 귀찮다면 운영으로 다운로드가 안됩니다 라고 말합니다.
			header.add("content-Disposition", "attachment;filename=\""+oriFile+"\"");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		// 보낼 내용, 헤더, 상태(200 또는 HttpStatus.OK 는 정상이라는 뜻)
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK); // HttpStatus.OK == 200 (정상 처리)
	}

	
	
	
	
	
	
	
	
	
	
	
}
