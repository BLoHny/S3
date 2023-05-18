package com.anything.s3.domain.article.presentation;

import com.anything.s3.domain.article.presentation.request.CreateArticleRequest;
import com.anything.s3.domain.article.service.CreateArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final CreateArticleService createArticleService;

    @PostMapping
    public ResponseEntity<?> createArticle(@RequestBody CreateArticleRequest articleRequest) {
        createArticleService.execute(articleRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
