package com.example.demo.rest;


import com.example.demo.data.model.Country;
import com.example.demo.services.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryRestController {


    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getCountries(){
        return this.countryService.getCountries();
    }

    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestParam String name, @RequestParam String continent) {
        return this.countryService.save(new Country(name, continent))
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Country> deleteById(@PathVariable Long id){

        if(this.countryService.findById(id).isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        this.countryService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
