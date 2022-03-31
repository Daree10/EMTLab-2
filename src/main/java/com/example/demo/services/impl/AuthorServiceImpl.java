package com.example.demo.services.impl;

import com.example.demo.data.dto.authorDto;
import com.example.demo.data.exceptions.AuthorNotFoundException;
import com.example.demo.data.exceptions.CountryNotFoundException;
import com.example.demo.data.model.Country;
import com.example.demo.data.model.author;
import com.example.demo.repository.AuthorRepossitory;
import com.example.demo.repository.CountryRepository;
import com.example.demo.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepossitory authorRepossitory;

    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepossitory authorRepossitory, CountryRepository countryRepository) {

        this.authorRepossitory = authorRepossitory;
        this.countryRepository = countryRepository;

        if(this.authorRepossitory.findAll().isEmpty()){

           // this.authorRepossitory.save(new author("Blaze", "Koneski", countryRepository.findById(0L).get()));
           // this.authorRepossitory.save(new author("Kiko", "Chausoski", countryRepository.findById(1L).get()));

        }
    }

    @Override
    public List<author> getAuthors() {

        return authorRepossitory.findAll();
    }

    @Override
    public Optional<author> findById(Long id) {
        return authorRepossitory.findById(id);
    }

    /*@Override
    public Optional<author> save(author b) {
        return Optional.of(authorRepossitory.save(b));
    }*/

    @Override
    public Optional<author> edit(Long id, authorDto a) {

        author author= authorRepossitory.findById(id).orElseThrow(()->new AuthorNotFoundException());

        Country country = countryRepository.findById(a.countryId).orElseThrow(()-> new CountryNotFoundException());


        author.setName(a.name);
        author.setSurname(a.surname);
        author.setCountry(country);

        return Optional.of(authorRepossitory.save(author));
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepossitory.deleteById(id);
    }

    @Override
    public Optional<author> save(String name, String surname, Long countryId) {

        Country country = countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException());

        author author = new author(name, surname, country);

        return Optional.of(this.authorRepossitory.save(author));

    }


}
