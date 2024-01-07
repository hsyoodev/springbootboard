package com.hsyoodev.springbootboard.service;

import com.hsyoodev.springbootboard.domain.Article;
import com.hsyoodev.springbootboard.domain.type.SearchType;
import com.hsyoodev.springbootboard.dto.ArticleDto;
import com.hsyoodev.springbootboard.dto.ArticleUpdateDto;
import com.hsyoodev.springbootboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {
    @InjectMocks
    private ArticleService articleService;
    @Mock
    private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면, 게시글 리스트를 반환한다.")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticles() {
        // given

        // when
        Page<ArticleDto> articles = articleService.searchArticles(SearchType.TITLE, "search keyword"); // 제목, 본문, ID, 닉네임, 해시태그

        // then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회하면, 게시글 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticle_thenReturnsArticle() {
        // given

        // when
        ArticleDto articleDto = articleService.searchArticle(1L);

        // then
        assertThat(articleDto).isNotNull();
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 수정한다.")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavesArticle() {
        // given
        ArticleDto articleDto = ArticleDto.of("title", "content", "hashtag", LocalDateTime.now(), "hsyoodev");
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // when
        articleService.saveArticle(articleDto);

        // then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 ID와 수정 정보를 입력하면, 게시글을 생성한다.")
    @Test
    void givenArticleIdAndModifiedInfo_whenUpdatingArticle_thenUpdatesArticle() {
        // given
        ArticleUpdateDto articleUpdateDto = ArticleUpdateDto.of("title", "content", "hashtag");
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // when
        articleService.updateArticle(1L, articleUpdateDto);

        // then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 ID를 입력하면, 게시글을 삭제한다.")
    @Test
    void givenArticleId_whenDeletingArticle_thenDeletesArticle() {
        // given
        willDoNothing().given(articleRepository).delete(any(Article.class));
        
        // when
        articleService.deleteArticle(1L);

        // then
        then(articleRepository).should().delete(any(Article.class));
    }
}