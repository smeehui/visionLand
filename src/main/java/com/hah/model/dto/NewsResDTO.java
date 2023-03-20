package com.hah.model.dto;

import com.hah.model.NewsImage;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class NewsResDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String subtitle;

    @OneToMany(mappedBy = "news")
    private List<NewsImageDTO> newsImage;

    private String content;

}
