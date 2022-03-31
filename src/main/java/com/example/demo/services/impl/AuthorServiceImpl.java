package com.example.demo.services.impl;

import com.example.demo.data.model.author;
import com.example.demo.repository.AuthorRepossitory;
import com.example.demo.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepossitory authorRepossitory;

    public AuthorServiceImpl(AuthorRepossitory authorRepossitory) {

        this.authorRepossitory = authorRepossitory;

        if(this.authorRepossitory.findAll().isEmpty()){

            this.authorRepossitory.save(new author("Blaze", "Koneski", countryService.findById(0L).get()));
            this.authorRepossitory.save(new author("Kiko", "Chausoski", countryService.findById(1L).get()));

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

    @Override
    public Optional<author> save(author b) {
        authorRepossitory.save(b);
        return Optional.of(b);
    }
}
