package com.example.imgurapp.controller;

import com.example.imgurapp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam MultipartFile file) {
        String message = imageService.uploadImage(username, password, file);
        return ResponseEntity.ok(message);
    }
}