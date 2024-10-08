package com.rodiugurlu.starter.repository;

import com.rodiugurlu.starter.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
