package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Person;

public interface PersonDAO extends CrudRepository<Person, Long> {

}