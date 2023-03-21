package com.hah.repository;

import com.hah.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;


@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
