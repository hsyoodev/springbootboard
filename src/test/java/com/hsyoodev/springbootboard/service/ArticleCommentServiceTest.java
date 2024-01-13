package com.hsyoodev.springbootboard.service;

import com.hsyoodev.springbootboard.domain.Article;
import com.hsyoodev.springbootboard.domain.ArticleComment;
import com.hsyoodev.springbootboard.domain.UserAccount;
import com.hsyoodev.springbootboard.repository.ArticleCommentRepository;
import com.hsyoodev.springbootboard.repository.ArticleRepository;
import com.hsyoodev.springbootboard.repository.UserAccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("비즈니스 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {
    @InjectMocks
    private ArticleCommentService articleCommentService;
    @Mock
    private ArticleRepository articleRepository;
    @Mock
    private ArticleCommentRepository articleCommentRepository;
    @Mock
    private UserAccountRepository userAccountRepository;

    @DisplayName("게시글 ID로 조회하면, 해당하는 댓글 리스트를 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticleComments_thenReturnsArticleComments() {
        // given
        Long articleId = 1L;
        UserAccount userAccount = userAccountRepository.save(UserAccount.of("uno", "pw", null, null, null));
        Article article = Article.of(userAccount, "title", "content", "#java");
        given(articleRepository.findById(articleId)).willReturn(Optional.of(article));

        // when
        List<ArticleComment> articleComments = articleCommentService.searchArticleComment(1L);

        // then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }
}