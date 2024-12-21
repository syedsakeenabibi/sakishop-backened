package com.thecodereveal.shopease.controllers;

import com.thecodereveal.shopease.services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
@CrossOrigin

public class FileUpload {

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping
    public ResponseEntity<?> fileUpload(@RequestParam(value = "file", required = true) MultipartFile file, @RequestParam(value = "fileName", required = true) String fileName) {
        try {
            int statusCode = fileUploadService.uploadFile(file, fileName);
            if (statusCode == 201) {
                return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed. Host returned status: " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

}