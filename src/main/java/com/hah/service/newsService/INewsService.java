package com.hah.service.newsService;

import com.hah.model.News;
import com.hah.model.dto.NewsImageDTO;
import com.hah.service.IGeneralService;
import org.springframework.web.multipart.MultipartFile;

public interface INewsService  extends IGeneralService<News> {
    NewsImageDTO uploadNewsImage(MultipartFile multipartFile);
}
