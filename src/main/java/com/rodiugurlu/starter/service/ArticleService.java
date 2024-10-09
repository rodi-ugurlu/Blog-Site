package com.rodiugurlu.starter.service;

import com.rodiugurlu.starter.dto.DtoArticle;
import com.rodiugurlu.starter.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticle();
}
