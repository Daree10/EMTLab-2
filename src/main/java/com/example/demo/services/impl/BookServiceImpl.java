package com.example.demo.services.impl;

import com.example.demo.data.dto.BookDto;
import com.example.demo.data.enumerations.Category;
import com.example.demo.data.exceptions.AuthorNotFoundException;
import com.example.demo.data.exceptions.BookNotFoundException;
import com.example.demo.data.model.Book;
import com.example.demo.data.model.author;
import com.example.demo.repository.AuthorRepossitory;
import org.springframework.stereotype.Service;
import com.example.demo.repository.BookRepository;
import com.example.demo.services.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private final AuthorRepossitory authorRepossitory;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepossitory authorRepossitory) {

        this.bookRepository = bookRepository;

        this.authorRepossitory = authorRepossitory;
    }

    @Override
    public List<Book> getBooks() {

        return bookRepository.findAll();

    }

    public Optional<Book> findById(Long id){

        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto b) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> save(String name, Integer copies, Category category, Long authorId) {

        author a = authorRepossitory.findById(authorId).orElseThrow(()->new AuthorNotFoundException());

        Book b = new Book(name, copies, category, a);

        return Optional.of(this.bookRepository.save(b));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {

        Book b = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException());

        author a = authorRepossitory.findById(bookDto.authorId).orElseThrow(()-> new AuthorNotFoundException());

        b.setName(bookDto.name);

        b.setAvailableCopies(bookDto.copies);

        b.setCategory(bookDto.category);

        b.setAuthor(a);

        return Optional.of(this.bookRepository.save(b));

    }


}
