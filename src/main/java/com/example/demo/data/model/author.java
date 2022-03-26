package com.example.demo.data.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @ManyToOne
    private Country country;

    public author(String name, String surname, Country country) {
        //this.id = (long)(Math.random()*1000);
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public author() {

    }
}
