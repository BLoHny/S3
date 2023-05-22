package com.anything.s3.domain.article.presentation.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter

public class CreateArticleRequest {

    @NotBlank(message = "제목은 필수 요소입니다.")
    private String title;

    private String content;
}
