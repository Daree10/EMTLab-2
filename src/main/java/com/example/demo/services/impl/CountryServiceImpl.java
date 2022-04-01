package com.example.demo.services.impl;

import com.example.demo.data.dto.CountryDto;
import com.example.demo.data.enumerations.Category;
import com.example.demo.data.exceptions.CountryNotFoundException;
import com.example.demo.data.model.Book;
import com.example.demo.data.model.Country;
import com.example.demo.data.model.author;
import com.example.demo.repository.AuthorRepossitory;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CountryRepository;
import com.example.demo.services.CountryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    private final AuthorRepossitory authorRepossitory;

    private final BookRepository bookRepository;

    public CountryServiceImpl(CountryRepository countryRepository, AuthorRepossitory authorRepossitory, BookRepository bookRepository){

        this.countryRepository = countryRepository;
        this.authorRepossitory = authorRepossitory;
        this.bookRepository = bookRepository;

        if(this.countryRepository.findAll().isEmpty()){

            this.countryRepository.save(new Country("Macedonia", "Europe"));
            this.countryRepository.save(new Country("Italy", "Europe"));
        }

       /* if(this.authorRepossitory.findAll().isEmpty()){

            this.authorRepossitory.save(new author("Vladimir", "Dostoevsky", countryRepository.findById(1L).get()));
            this.authorRepossitory.save(new author("Kocho", "Racin", countryRepository.findById(0L).get()));
        }*/
/*
        if(this.bookRepository.findAll().isEmpty()){

            this.bookRepository.save(new Book("Lord of the rings", 2, Category.FANTASY, this.authorRepossitory.findById(0L).get()));
        }*/

    }

    @Override
    public List<Country> getCountries() {

        return countryRepository.findAll();


    }

    @Override
    public Optional<Country> findById(Long id) {

        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(Country b) {
        return Optional.of(this.countryRepository.save(b));
    }

    @Override
    @Transactional
    public Optional<Country> edit(Long id, CountryDto c) {

        Country country = countryRepository.findById(id).orElseThrow(()-> new CountryNotFoundException());

        country.setName(c.name);
        country.setContinent(c.continent);

        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }


}
