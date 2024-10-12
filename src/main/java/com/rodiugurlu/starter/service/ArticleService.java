package com.rodiugurlu.starter.service;

import com.rodiugurlu.starter.dto.DtoArticle;

import java.util.List;

public interface ArticleService {
    List<DtoArticle> getArticles();
List<DtoArticle> getArticlesByCategory(int categoryId);

}
