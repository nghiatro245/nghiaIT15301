package com.it15301.utilities;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileUtils {
	public File handleUploadFile(MultipartFile uploadedFile) {
		String folderPath = "C:\\Users\\Quang Nghia\\eclipse-workspace\\IT15301\\src\\main\\webapp\\storage";
		File myUploadFolder = new File(folderPath);
		
		//Kiểm tra thư mục lưu trữ có tồn tại không
		if(!myUploadFolder.exists()) {
			myUploadFolder.mkdirs();
		}
		
		// Lưu file vào thư mục đã chọn
		File savedFile = null;
		try {
			String uuid = UUID.randomUUID().toString();
			String fileName = uuid + "_" + uploadedFile.getOriginalFilename();
			savedFile = new File(myUploadFolder,fileName);
			uploadedFile.transferTo(savedFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return savedFile;
	}
}
