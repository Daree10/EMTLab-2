package com.example.demo.services;

import com.example.demo.data.model.Book;
import com.example.demo.data.model.author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<author> getAuthors();

    Optional<author> findById(Long id);

    Optional<author> save(author b);

}
