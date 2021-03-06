package com.example.demo.services;

import com.example.demo.data.dto.CountryDto;
import com.example.demo.data.model.Book;
import com.example.demo.data.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CountryService {

    List<Country> getCountries();

    Optional<Country> findById(Long id);

    Optional<Country> save(Country b);

    Optional<Country> edit(Long id, CountryDto c);

    void deleteById(Long id);
}
