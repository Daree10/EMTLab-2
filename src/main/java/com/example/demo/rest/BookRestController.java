package com.example.demo.rest;

import com.example.demo.data.enumerations.Category;
import com.example.demo.data.model.Book;
import com.example.demo.data.model.Country;
import com.example.demo.data.model.author;
import com.example.demo.services.AuthorService;
import com.example.demo.services.BookService;
import com.example.demo.services.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping(value={"/api/books", ""})
public class BookRestController {

    private final BookService bookService;

    private final AuthorService authorService;

    private final CountryService countryService;



    public BookRestController(BookService bookService, AuthorService authorService, CountryService countryService) {

        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;

    }

    @GetMapping
    public List<Book> getBooks(){

        return bookService.getBooks();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){

        return this.bookService.findById(id)
                .map(book-> ResponseEntity.ok().body(book))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostConstruct
    public void init(){






/*
        if(this.bookService.getBooks().isEmpty()){

            this.bookService.save(new Book("Grdoto Pajce", 3, Category.FANTASY, authorService.findById(0L).get()));
            this.bookService.save(new Book("Hajdi", 21, Category.FANTASY, authorService.findById(1L).get()));

        }*/


    }

    /*@PostMapping("save")
    public ResponseEntity<Book> Save()*/

}
