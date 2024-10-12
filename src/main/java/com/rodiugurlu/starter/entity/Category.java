package com.rodiugurlu.starter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "category")
@Data
public class Category {
    @Id
    private int id;

    private String categoryName;

    @OneToMany
    List<Article> article;

}
