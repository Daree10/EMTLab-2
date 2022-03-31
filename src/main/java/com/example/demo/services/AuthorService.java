package com.example.demo.services;

import com.example.demo.data.dto.CountryDto;
import com.example.demo.data.dto.authorDto;
import com.example.demo.data.model.Book;
import com.example.demo.data.model.Country;
import com.example.demo.data.model.author;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public interface AuthorService {

    List<author> getAuthors();

    Optional<author> findById(Long id);

    //Optional<author> save(author b);

    Optional<author> edit(Long id, authorDto a);

    void deleteById(Long id);


    Optional<author> save(String name, String surname, Long countryId);
}
