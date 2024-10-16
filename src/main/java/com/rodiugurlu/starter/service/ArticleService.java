package com.rodiugurlu.starter.service;

import com.rodiugurlu.starter.dto.DtoArticle;
import com.rodiugurlu.starter.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getArticles();
    List<DtoArticle> getArticlesByCategory(String categoryName);
    DtoArticle postArticle(DtoArticle article);
    void deleteArticleById(int id);
    Article getArticleById(int id);
    DtoArticle updateArticleById(int id,DtoArticle article);
}
