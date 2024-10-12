package com.rodiugurlu.starter.controller;

import com.rodiugurlu.starter.dto.DtoArticle;
import com.rodiugurlu.starter.entity.Article;
import com.rodiugurlu.starter.service.ArticleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/article")
public class ArticleController {
    private ArticleService articleService;
    @GetMapping("/getArticles")
    public List<DtoArticle> getArticles() {
        return articleService.getArticles();
    }

    @PostMapping("/postArticle")
    @ResponseStatus(code = HttpStatus.CREATED)
    public DtoArticle postArticle(@RequestBody @Valid Article savedArticle) {
        return articleService.postArticle(savedArticle);

    }


}
