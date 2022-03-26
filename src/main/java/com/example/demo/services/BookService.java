package com.example.demo.services;

import com.example.demo.data.enumerations.Category;
import com.example.demo.data.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService{

    List<Book> getBooks();

    Optional<Book> findById(Long id);

    Optional<Book> save(Book b);

}
