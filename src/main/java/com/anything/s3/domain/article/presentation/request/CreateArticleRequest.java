package com.anything.s3.domain.article.presentation.request;

import lombok.Getter;

@Getter

public class CreateArticleRequest {

    private String title;
    private String content;
}
