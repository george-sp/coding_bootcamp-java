package com.example.controller;

import com.example.dao.TodoDAO;
import com.example.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoDAO repository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<Todo> getAll() {
        return repository.findAll();
    }

}
