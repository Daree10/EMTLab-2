package com.example.demo.data.dto;

public class authorDto {


    public authorDto(String name, String surname, Long countryId) {
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
    }

    public String name;
    public String surname;
    public Long countryId;
}
