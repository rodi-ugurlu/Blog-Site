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

    @GetMapping
    public List<DtoArticle> getArticles() {
        return articleService.getArticles();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public DtoArticle postArticle(@RequestBody @Valid DtoArticle dtoArticle) {
        return articleService.postArticle(dtoArticle);
    }

    @GetMapping("/get/{categoryName}")
    public List<DtoArticle> getArticleByCategory(@PathVariable String categoryName) {
        return articleService.getArticlesByCategory(categoryName);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable (name = "id") int id) {
    articleService.deleteArticleById(id);
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable (name = "id") int id) {
        return articleService.getArticleById(id);
    }
}
