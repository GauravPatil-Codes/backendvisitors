package com.minister.visitorsapp.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.minister.visitorsapp.helpers.FTPClientHelper;
import com.minister.visitorsapp.models.UploadResponse;



@RestController
public class FileUploadController {

    @Autowired
    private FTPClientHelper ftpClientHelper;

    @PostMapping("/upload")
    public ResponseEntity<UploadResponse> uploadProductImages(@RequestParam("file") MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
        	String originalFileName = file.getOriginalFilename();
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String remoteFileName = originalFileName + "_" + timestamp;
            String fileUrl = ftpClientHelper.uploadFile(inputStream, remoteFileName);

            if (fileUrl != null) {
                UploadResponse response = new UploadResponse(200, fileUrl);
                return ResponseEntity.status(200).body(response);
            } else {
                UploadResponse response = new UploadResponse(500, "File upload failed.");
                return ResponseEntity.status(500).body(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
            UploadResponse response = new UploadResponse(500, "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}