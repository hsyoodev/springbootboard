package com.hsyoodev.springbootboard.service;

import com.hsyoodev.springbootboard.domain.type.SearchType;
import com.hsyoodev.springbootboard.dto.ArticleDto;
import com.hsyoodev.springbootboard.dto.ArticleUpdateDto;
import com.hsyoodev.springbootboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType title, String search_keyword) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(long articleId) {
        return null;
    }

    public void saveArticle(ArticleDto articleDto) {
    }

    public void updateArticle(long articleId, ArticleUpdateDto articleUpdateDto) {

    }

    public void deleteArticle(long articleId) {
    }
}
