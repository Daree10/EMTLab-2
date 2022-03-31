package com.example.demo.rest;


import com.example.demo.data.dto.CountryDto;
import com.example.demo.data.dto.authorDto;
import com.example.demo.data.model.Country;
import com.example.demo.data.model.author;
import com.example.demo.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService authorService;


    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<author> getAuthors(){
        return this.authorService.getAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<author> findById(@PathVariable Long id){

        return this.authorService.findById(id).
                map(a -> ResponseEntity.ok().body(a))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/add")
    public ResponseEntity<author> save(@RequestBody authorDto authorDto) {
        return this.authorService.save(authorDto.name, authorDto.surname, authorDto.countryId)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<author> deleteById(@PathVariable Long id){

        if(this.authorService.findById(id).isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        this.authorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<author> edit(@PathVariable Long id, @RequestBody authorDto a){

        return this.authorService.edit(id,a)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
