package com.example.demo.services.impl;

import com.example.demo.data.model.Country;
import com.example.demo.repository.CountryRepository;
import com.example.demo.services.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository){

        this.countryRepository = countryRepository;

        if(this.countryRepository.findAll().isEmpty()){

            this.countryRepository.save(new Country("Macedonia", "Europe"));
            this.countryRepository.save(new Country("Italy", "Europe"));
        }

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
        countryRepository.save(b);
        return Optional.of(b);
    }
}
