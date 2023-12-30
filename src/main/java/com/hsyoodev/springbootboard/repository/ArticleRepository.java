package com.hsyoodev.springbootboard.repository;

import com.hsyoodev.springbootboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
