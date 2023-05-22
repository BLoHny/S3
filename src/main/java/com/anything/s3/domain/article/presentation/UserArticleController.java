package com.anything.s3.domain.article.presentation;

import com.anything.s3.domain.article.presentation.request.CreateArticleRequest;
import com.anything.s3.domain.article.presentation.response.ListArticleResponse;
import com.anything.s3.domain.article.service.CreateArticleService;
import com.anything.s3.domain.article.service.ListArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/article")
public class UserArticleController {

    private final CreateArticleService createArticleService;

    private final ListArticleService listArticleService;

    @PostMapping
    public ResponseEntity<?> createArticle(@RequestBody @Valid CreateArticleRequest articleRequest, @RequestPart("file") List<MultipartFile> files) {
        createArticleService.execute(articleRequest, files);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<ListArticleResponse> boardList() {
        var list = listArticleService.execute();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
