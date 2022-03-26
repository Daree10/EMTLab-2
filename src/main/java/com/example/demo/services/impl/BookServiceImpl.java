package com.example.demo.services.impl;

import com.example.demo.data.model.Book;
import org.springframework.stereotype.Service;
import com.example.demo.repository.BookRepository;
import com.example.demo.services.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {

        this.bookRepository = bookRepository;

    }

    @Override
    public List<Book> getBooks() {

        return bookRepository.findAll();

    }

    public Optional<Book> findById(Long id){

        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(Book b) {
        return Optional.empty();
    }
}
