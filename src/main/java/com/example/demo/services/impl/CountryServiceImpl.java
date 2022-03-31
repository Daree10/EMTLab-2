package com.example.demo.services.impl;

import com.example.demo.data.dto.CountryDto;
import com.example.demo.data.exceptions.CountryNotFoundException;
import com.example.demo.data.model.Country;
import com.example.demo.repository.CountryRepository;
import com.example.demo.services.CountryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
