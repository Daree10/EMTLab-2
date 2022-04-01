package com.example.demo.data.dto;

import com.example.demo.data.enumerations.Category;

public class BookDto {

    public BookDto(String name, Integer copies, Category category, Long authorId) {
        this.name = name;
        this.copies = copies;
        this.category = category;
        this.authorId = authorId;
    }

    public String name;

    public Integer copies;

    public Category category;

    public Long authorId;
}
