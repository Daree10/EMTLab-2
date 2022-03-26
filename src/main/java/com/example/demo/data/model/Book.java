package com.example.demo.data.model;

import com.example.demo.data.enumerations.Category;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer AvailableCopies;

    public Book(String name, Integer availableCopies, Category category, com.example.demo.data.model.author author) {
       // this.id = (long)(Math.random()*1000);
        this.name = name;
        AvailableCopies = availableCopies;
        this.category = category;
        this.author = author;
    }

    private Category category;

    @ManyToOne
    private author author;

    public Book() {

    }
}