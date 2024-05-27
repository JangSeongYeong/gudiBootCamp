package kr.co.gudi.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.co.gudi.service.FileService;

@Controller
public class FileController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private final FileService service;

	public FileController(FileService service) {
		this.service = service;
	}
		
	@GetMapping(value = "/")
	public String home() {
		logger.info("Home Here");
		return "home";
	}
	
	@GetMapping(value = "/list")
	public String getList(Model model) {
		List<Map<String, String>> fileList = service.getList();
		model.addAttribute("list", fileList);
		return "result";
	}
	
	@PostMapping(value = "/upload")
	public String upload(MultipartFile file) {
		logger.info("upload single file : "+file);
		service.upload(file);
		return "redirect:/list";
	}

	@PostMapping(value = "/multiUpload")
	public String multiUpload(MultipartFile[] files) {
		logger.info("Upload Multi Files: "+files.length);
		service.multiUpload(files);
		return "redirect:/list";
	}

	/*
	@RequestMapping(value = "/photo/{fileName}")
	public ResponseEntity<Resource> imgView(@PathVariable String fileName) {
		logger.info("Response Images: "+fileName);
		return service.imgView(fileName);
	}
	*/

	@RequestMapping(value = "/download/{fileName}")
	public ResponseEntity<Resource> download(@PathVariable String fileName) {
		logger.info("download Images: "+fileName);
		return service.download(fileName);
	}
	
	@GetMapping(value = "/delete")
	public String delete(String file) {
		logger.info("delete file: "+file);
		service.delete(file);
		return "redirect:/list";
	}
	
	

}
