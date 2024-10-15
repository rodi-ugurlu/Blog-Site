package com.rodiugurlu.starter.manager;

import com.rodiugurlu.starter.dto.DtoArticle;
import com.rodiugurlu.starter.dto.DtoCategory;
import com.rodiugurlu.starter.entity.Category;
import com.rodiugurlu.starter.repository.CategoryRepository;
import com.rodiugurlu.starter.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        List<Category> allCategory= categoryRepository.findAll();
        return allCategory;
    }

    @Override
    public DtoCategory addCategory(DtoCategory dtoCategory) {
        Category category = new Category();
        BeanUtils.copyProperties(dtoCategory, category);
        categoryRepository.save(category);
        return dtoCategory;
    }
}
