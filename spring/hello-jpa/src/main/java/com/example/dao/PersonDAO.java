package com.example.dao;

import com.example.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonDAO extends CrudRepository<Person, Long> {

    Iterable<Person> findByName(@Param("name") String name);

    Iterable<Person> findByNameOrSurname(@Param("name") String name, @Param("surname") String surname);

    long countByName(String name);

    @Query("SELECT COUNT(p) FROM Person p WHERE p.surname = ?1")
    long countByLastName(String surname);
}