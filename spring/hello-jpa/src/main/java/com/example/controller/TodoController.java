package com.example.controller;

import com.example.dao.TodoDAO;
import com.example.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoDAO repository;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Iterable<Todo> getAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/findOne/{todoID}")
    public Todo getOne(@PathVariable long todoID) {
        return repository.findOne(todoID);
    }

    @RequestMapping(value = "/saveOne", method = RequestMethod.GET)
    public Todo createOne(@RequestParam(value = "person_id") long personID, @RequestParam(value = "text") String todoText) {
        return repository.save(new Todo(todoText, personID));
    }

    @RequestMapping(value = "/deleteOne", method = RequestMethod.GET)
    public Todo deleteOne(@RequestParam(value = "id") long todoID) {
        Todo deletedTodo = repository.findOne(todoID);
        repository.delete(deletedTodo);
        return deletedTodo;
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public Iterable<Todo> deleteAll() {
        Iterable<Todo> deletedTodos = repository.findAll();
        repository.delete(deletedTodos);
        return deletedTodos;
    }
}
