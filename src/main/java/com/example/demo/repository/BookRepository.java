package com.example.demo.repository;

import com.example.demo.bootstrap.DataHolder;
import com.example.demo.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {



}
