package com.gtt.shoppingstoreback.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class imageController {

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile images){return null;}
}
