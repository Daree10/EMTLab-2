package com.example.demo.services;

import com.example.demo.data.dto.BookDto;
import com.example.demo.data.dto.authorDto;
import com.example.demo.data.enumerations.Category;
import com.example.demo.data.model.Book;
import com.example.demo.data.model.author;

import java.util.List;
import java.util.Optional;

public interface BookService{

    List<Book> getBooks();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto b);

    Optional<Book> save(String name, Integer copies, Category category,  Long authorId);

    void deleteById(Long id);

    Optional<Book> edit(Long id, BookDto bookDto);

}
