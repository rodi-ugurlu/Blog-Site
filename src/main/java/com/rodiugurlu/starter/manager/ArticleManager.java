package com.rodiugurlu.starter.manager;

import com.rodiugurlu.starter.dto.DtoArticle;
import com.rodiugurlu.starter.dto.DtoCategory;
import com.rodiugurlu.starter.entity.Article;
import com.rodiugurlu.starter.entity.Category;
import com.rodiugurlu.starter.exception.BaseException;
import com.rodiugurlu.starter.exception.ErrorMessage;
import com.rodiugurlu.starter.exception.MessageType;
import com.rodiugurlu.starter.repository.ArticleRepository;
import com.rodiugurlu.starter.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArticleManager implements ArticleService {
    private ArticleRepository articleRepository;

    @Override
    public List<DtoArticle> getArticles() {
        DtoCategory category = new DtoCategory();
        List<Article> articles = articleRepository.findAll();
        List<DtoArticle> dtoArticles = new ArrayList<>();
        for (Article item : articles) {
            DtoArticle dtoArticle = new DtoArticle();
            BeanUtils.copyProperties(item, dtoArticle);
            if (item.getCategory() != null) {
                DtoCategory dtoCategory = new DtoCategory();
                BeanUtils.copyProperties(item.getCategory(), dtoCategory);
            }
            BeanUtils.copyProperties(category, dtoArticle);
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
        Category category = articleRepository.findCategoryByName(dtoArticle.getDtoCategory().getCategoryName());
        articleEntity.setCategory(category);
        articleRepository.save(articleEntity);
        DtoCategory dtoCategory = new DtoCategory();
        BeanUtils.copyProperties(category, dtoCategory);
//        dtoArticle.setDtoCategory(dtoCategory);
        return dtoArticle;

    }

    @Override
    public void deleteArticleById(int id) {
        Optional<Article> optional = articleRepository.findById(id);
        if (optional.isPresent()) {
            articleRepository.delete(optional.get());
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, String.valueOf(id)));
    }

    @Override
    public Article getArticleById(int id) {
        Optional<Article> op = articleRepository.findById(id);
        if (op.isPresent()) {
            return op.get();
        }
        throw new BaseException(new ErrorMessage(MessageType.RECORD_NOT_FOUND, String.valueOf(id)));
    }
}
