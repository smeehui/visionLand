package com.hah.controller.api;

import com.hah.model.dto.NewsImageDTO;
import com.hah.service.newsService.INewsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/news")
public class NewsAPI {
    private final ModelMapper modelMapper;
    private final INewsService newsService;

    @Autowired
    public NewsAPI(ModelMapper modelMapper,INewsService newsService){
        this.modelMapper = modelMapper;
        this.newsService = newsService;
    }

    @PostMapping("/image")
    public ResponseEntity<?> uploadImage(NewsImageDTO newsImageDTO){

        System.out.println(newsImageDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
