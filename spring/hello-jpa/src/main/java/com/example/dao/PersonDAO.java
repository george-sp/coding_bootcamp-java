package com.example.dao;

import com.example.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonDAO extends CrudRepository<Person, Long> {

    Iterable<Person> findByName(@Param("name") String name);
}