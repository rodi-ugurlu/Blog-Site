package com.rodiugurlu.starter.repository;

import com.rodiugurlu.starter.dto.DtoCategory;
import com.rodiugurlu.starter.entity.Article;
import com.rodiugurlu.starter.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @Query("SELECT a FROM Article a JOIN a.category c WHERE c.categoryName = ?1")
    List<Article> findArticleByCategory(String categoryName);


}
