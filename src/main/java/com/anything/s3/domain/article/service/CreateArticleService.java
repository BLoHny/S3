package com.anything.s3.domain.article.service;

import com.anything.s3.domain.article.entity.Article;
import com.anything.s3.domain.article.presentation.request.CreateArticleRequest;
import com.anything.s3.domain.article.repository.ArticleRepository;
import com.anything.s3.domain.member.entity.Member;
import com.anything.s3.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateArticleService {

    private final ArticleRepository articleRepository;
    private final UserUtil userUtil;

    public void execute(CreateArticleRequest articleRequest) {

        if(articleRepository.existsByContent(articleRequest.getContent())) {
            throw new RuntimeException("이미 존재하는 제목 글입니다.");
        }

        Member member = userUtil.currentUser();

        Article article = Article.builder()
                .title(articleRequest.getTitle())
                .content(articleRequest.getContent())
                .createDate(DateTime.now())
                .member(member)
                .build();

        articleRepository.save(article);
    }
}
