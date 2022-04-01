package com.example.demo.rest;

import com.example.demo.data.dto.BookDto;
import com.example.demo.data.dto.CountryDto;
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


    @PostMapping("/add")
    public ResponseEntity<Book> save (@RequestBody BookDto book){

        return this.bookService.save(book.name, book.copies, book.category, book.authorId)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){

        if(this.bookService.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        this.bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto bookDto){

        return this.bookService.edit(id, bookDto)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
