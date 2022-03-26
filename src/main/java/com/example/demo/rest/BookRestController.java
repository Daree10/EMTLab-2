package com.example.demo.rest;

import com.example.demo.data.enumerations.Category;
import com.example.demo.data.model.Book;
import com.example.demo.services.AuthorService;
import com.example.demo.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value={"/api/books", ""})
public class BookRestController {

    private final BookService bookService;

    private final AuthorService authorService;



    public BookRestController(BookService bookService, AuthorService authorService) {

        this.bookService = bookService;
        this.authorService = authorService;

        if(this.authorService.getAuthors().isEmpty()){

            authorService

        }

        if(this.bookService.getBooks().isEmpty()){

            this.bookService.save(new Book("Grdoto Pajce", 3, Category.FANTASY, Authors.get(0)));

        }

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

    /*@PostMapping("save")
    public ResponseEntity<Book> Save()*/

}
