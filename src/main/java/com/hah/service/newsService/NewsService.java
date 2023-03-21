package com.hah.service.newsService;

import com.hah.model.News;
import com.hah.model.dto.NewsImageDTO;
import com.hah.repository.NewsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService implements INewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public Optional<News> findById(Long id) {
        return newsRepository.findById(id);
    }

    @Override
    public News save(News news) {
        return newsRepository.save(news);
    }

    @Override
    public void deleteById(Long id) {
        newsRepository.deleteById(id);
    }

    @Override
    public void delete(News news) {
        newsRepository.delete(news);
    }

    @Override
    public NewsImageDTO uploadNewsImage(MultipartFile multipartFile) {

        return null;
    }
}
