package com.example.demo.repository;

import com.example.demo.entity.article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


public interface articleRepository extends CrudRepository<article, Long> {

    @Override
    ArrayList<article> findAll();
}
