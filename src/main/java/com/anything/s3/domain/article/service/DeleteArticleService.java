package com.anything.s3.domain.article.service;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.exception.ArticleNotFoundException;
import com.anything.s3.domain.article.repository.ArticleRepository;
import com.anything.s3.domain.file.entity.ArticleFile;
import com.anything.s3.domain.file.repository.ArticleFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleFileRepository articleFileRepository;

    @Transactional
    public void execute(Long articleId) {

        Article article = articleRepository.findById(articleId)
                .orElseThrow(ArticleNotFoundException::new);

        List<ArticleFile> articleFile = articleFileRepository.getBoardFileByArticleId(articleId);

        articleFileRepository.delete((ArticleFile) articleFile);

        articleRepository.delete(article);
    }
}
