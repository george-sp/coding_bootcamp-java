package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.TodoDAO;
import com.example.model.Todo;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoDAO repository;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Todo> get() {
		return repository.findAll();
	}
}
