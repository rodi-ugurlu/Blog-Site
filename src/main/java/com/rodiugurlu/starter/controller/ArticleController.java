package com.rodiugurlu.starter.controller;

import com.rodiugurlu.starter.entity.Article;
import com.rodiugurlu.starter.manager.ArticleManager;
import com.rodiugurlu.starter.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    private ArticleManager articleManager;


    @GetMapping
    private List<Article> getArticles() {
        return articleManager.getAllArticles();
    }



}
