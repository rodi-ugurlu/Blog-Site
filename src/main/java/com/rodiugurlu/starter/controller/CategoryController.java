package com.rodiugurlu.starter.controller;

import com.rodiugurlu.starter.dto.DtoCategory;
import com.rodiugurlu.starter.entity.Category;
import com.rodiugurlu.starter.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    @Autowired // constructer autowired vs field autowired
    private CategoryService categoryService;

    @GetMapping
    List<Category> getAllCategories() {
        return categoryService.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    DtoCategory createCategory(@RequestBody @Valid DtoCategory dtoCategory) {
        return categoryService.addCategory(dtoCategory);
    }
}
