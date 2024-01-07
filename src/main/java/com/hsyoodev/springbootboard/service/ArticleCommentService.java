package com.hsyoodev.springbootboard.service;

import com.hsyoodev.springbootboard.domain.ArticleComment;
import com.hsyoodev.springbootboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {
    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public List<ArticleComment> searchArticleComment(long articleId) {
        return List.of();
    }
}
