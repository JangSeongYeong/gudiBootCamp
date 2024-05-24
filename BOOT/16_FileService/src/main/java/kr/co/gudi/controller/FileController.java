package kr.co.gudi.controller;

import java.util.List;

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
		return "home";
	}
	
	@PostMapping(value = "/upload")
	public String upload(MultipartFile uploadFile) { // jsp에서 보낸거랑 이름 맞추기 (uploadFile)
		logger.info("upload file : "+uploadFile.getOriginalFilename());
		service.upload(uploadFile);
		return "redirect:/fileList";
	}
	
	@PostMapping(value = "/multiUpload")
	public String multiUpload(MultipartFile[] files) { // jsp에서 보낸거랑 이름 맞추기 (uploadFile)
		logger.info("file length : "+files.length);
		service.multiUpload(files);
		return "redirect:/fileList";
	}

	@GetMapping(value = "/fileList")
	public String fileList(Model model) {
		List<String> list = service.fileList();
		logger.info("list : {}", list);
		model.addAttribute("list", list);
		return "result";
	}

	@RequestMapping(value = "/photo/{fileName}")
	public ResponseEntity<Resource> imgView(@PathVariable String fileName) { //Resource -> org.springframework.core.io.Resource
		logger.info("fileName : "+fileName);
		return service.imgView(fileName);
	}
	
	@RequestMapping(value = "/download/{fileName}")
	public ResponseEntity<Resource> download(@PathVariable String fileName) { //Resource -> org.springframework.core.io.Resource
		logger.info("download fileName : "+fileName);
		return service.download(fileName);
	}
	
	@GetMapping(value = "/delete")
	public String delete(String file) {
		logger.info("delete file name");
		service.delete(file);
		return "redirect:/fileList";
	}
	
	
	
	
	
	
	
}
