package com.example.demo.repository;

import com.example.demo.data.model.author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepossitory extends JpaRepository<author, Long> {


}
