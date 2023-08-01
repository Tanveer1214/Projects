package com.student.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String dir = Paths.get("src/main/resources/static/image").toAbsolutePath().toString();
	
	public boolean uploadFile(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), Paths.get(dir+File.separatorChar+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
