package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.student.helper.FileUploadHelper;

@RestController
public class FileController {

	@Autowired
	FileUploadHelper helper;
	
	@PostMapping("/file-upload")
	public ResponseEntity<String> uploadFile(@RequestParam("img") MultipartFile multipartFile) {
		try {
			if(helper.uploadFile(multipartFile)) {
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(multipartFile.getOriginalFilename()).toUriString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.internalServerError().body("Operation Failed");
	}
	
}
