package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Todo;

public interface TodoDAO extends CrudRepository<Todo, Long> {

}
