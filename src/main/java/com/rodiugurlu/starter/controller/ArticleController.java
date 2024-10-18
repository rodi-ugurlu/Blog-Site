package com.rodiugurlu.starter.controller;

import com.rodiugurlu.starter.dto.DtoArticle;
import com.rodiugurlu.starter.entity.Article;
import com.rodiugurlu.starter.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor // requiredargsconstructor - / farklarını araştır
@RequestMapping("/article")// we don't need any explain, cause with swagger showing everything.
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Operation(summary = "Update article api")
    @PutMapping("/{id}")
        public ResponseEntity<DtoArticle> update(@RequestBody @Valid DtoArticle dtoArticle, @PathVariable int id) {
        articleService.updateArticleById(id, dtoArticle);
        return new ResponseEntity<>(dtoArticle, HttpStatus.OK);
    }

    @Operation(summary = "List article api")
    @GetMapping
    public List<Article> getArticles() {
        return articleService.getArticles();
    }

     @Operation(summary = "Create article api")
    @PostMapping() // CRUD api's // in swagger web sites,you can see "post" part so we dont need.
    @ResponseStatus(code = HttpStatus.CREATED)
    public DtoArticle postArticle(@RequestBody @Valid DtoArticle dtoArticle) {
        return articleService.postArticle(dtoArticle);
    }

    @Operation(summary = "Get article api ")
    @GetMapping("/{categoryName}")
    public List<DtoArticle> getArticleByCategory(@PathVariable String categoryName) {
        return articleService.getArticlesByCategory(categoryName);
    }

    @Operation(summary = "Delete article api")
    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable (name = "id") int id) {
    articleService.deleteArticleById(id);
    }

    @Operation(summary = "Get article api")
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable (name = "id") int id) {
        return articleService.getArticleById(id);
    }
}
