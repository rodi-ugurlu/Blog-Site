package com.rodiugurlu.starter.service;

import com.rodiugurlu.starter.dto.DtoCategory;
import com.rodiugurlu.starter.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    DtoCategory addCategory(DtoCategory dtoCategory);
}
