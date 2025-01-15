package com.example.imgurapp.service;

import com.example.imgurapp.model.User;
import com.example.imgurapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

    @Autowired
    private UserRepository userRepository;

    public String uploadImage(String username, String password, MultipartFile file) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("Invalid username or password");
        }
        // Integrate with Imgur API here
        return "Image uploaded successfully";
    }
}