package com.example.demo.bootstrap;

import com.example.demo.data.enumerations.Category;
import com.example.demo.data.model.Book;
import com.example.demo.data.model.Country;
import com.example.demo.data.model.author;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Book> Books = new ArrayList<>();

    public static List<author> Authors = new ArrayList<>();

    public static List <Country> Country = new ArrayList<>();

    @PostConstruct
    public void init(){

        Country.add(new Country("Mexico","North America"));

        Country.add(new Country("Brazil","South America"));

        Country.add(new Country("Macedonia","Europe"));

        Authors.add(new author("Dostoevki", "Dostoestovski", Country.get(2)));

        Authors.add(new author("Petar", "Graso", Country.get(1)));

        Authors.add(new author("Tolstoj", "Prajt Tostoj", Country.get(0)));

        Books.add(new Book("Hajdi", 2, Category.DRAMA, Authors.get(1)));

        Books.add(new Book("Grdoto pajce", 13, Category.BIOGRAPHY, Authors.get(0)));

        Books.add(new Book("AOK", 2, Category.THRILER, Authors.get(2)));
    }

}
