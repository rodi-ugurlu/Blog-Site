package com.rodiugurlu.starter.controller;

import com.rodiugurlu.starter.dto.DtoArticle;
import com.rodiugurlu.starter.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
