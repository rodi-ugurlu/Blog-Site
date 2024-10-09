package com.rodiugurlu.starter.manager;

import com.rodiugurlu.starter.entity.Article;
import com.rodiugurlu.starter.repository.ArticleRepository;
import com.rodiugurlu.starter.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleManager implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
}
