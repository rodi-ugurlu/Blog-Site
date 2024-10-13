package com.rodiugurlu.starter.manager;

import com.rodiugurlu.starter.dto.DtoArticle;
import com.rodiugurlu.starter.dto.DtoCategory;
import com.rodiugurlu.starter.entity.Article;
import com.rodiugurlu.starter.entity.Category;
import com.rodiugurlu.starter.repository.ArticleRepository;
import com.rodiugurlu.starter.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ArticleManager implements ArticleService {
    private ArticleRepository articleRepository;

    @Override
    public List<DtoArticle> getArticles() {
        List<Article> articles = articleRepository.findAll();
        List<DtoArticle> dtoArticles = new ArrayList<>();
        for (Article item : articles) {
            DtoArticle dtoArticle = new DtoArticle();
            BeanUtils.copyProperties(item, dtoArticle);
            dtoArticles.add(dtoArticle);
        }
        return dtoArticles;
    }

    @Override
    public List<DtoArticle> getArticlesByCategory(String categoryName) {
        List<DtoArticle> dtoArticles = new ArrayList<>();
        List<Article> articles = articleRepository.findArticleByCategory(categoryName);
        for (Article item : articles) {
            DtoArticle dtoArticle = new DtoArticle();
            BeanUtils.copyProperties(item, dtoArticle);
            dtoArticles.add(dtoArticle);
        }
        return dtoArticles;
    }

    @Override
    public DtoArticle postArticle(DtoArticle dtoArticle) {
        Article articleEntity = new Article();
        BeanUtils.copyProperties(dtoArticle, articleEntity);
        articleRepository.save(articleEntity);
        DtoCategory dtoCategory = new DtoCategory();
        dtoArticle.setDtoCategory(dtoCategory);
        return dtoArticle;
    }
}
