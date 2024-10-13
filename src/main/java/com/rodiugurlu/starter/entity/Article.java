package com.rodiugurlu.starter.entity;

import com.rodiugurlu.starter.dto.DtoCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "article_table")
public class Article {
    @Id
    @Column(nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Column(length = 100000)
    private String content;
    @ManyToOne
    private Category category;

}
