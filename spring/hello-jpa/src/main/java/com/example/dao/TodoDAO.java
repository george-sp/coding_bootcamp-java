package com.example.dao;

import com.example.model.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TodoDAO extends CrudRepository<Todo, Long> {

    @Query(value = "SELECT * FROM todo WHERE todo.person_id = :person_id", nativeQuery = true)
    Iterable<Todo> findByPersonID(@Param("person_id") long person_id);
}
