package com.hah.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/news")
    public String newsManagementPage(){
        return "management/news/news";
    }

    @GetMapping("/news/create")
    public String createNewsPage(){
        return "management/news/create";
    }
}
