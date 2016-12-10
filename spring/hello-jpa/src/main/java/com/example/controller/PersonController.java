package com.example.controller;

import com.example.dao.PersonDAO;
import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by george on 10/12/2016.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonDAO repository;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Iterable<Person> getAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/findOne")
    public Person getOne(@RequestParam(value = "id") long personID) {
        return repository.findOne(personID);
    }

    @RequestMapping(value = "/saveOne")
    public Person createOne(@RequestParam(value = "id") long personID, @RequestParam(value = "name") String personName) {
        return repository.save(new Person(personID, personName));
    }

    @RequestMapping(value = "/deleteOne")
    public Person deleteOne(@RequestParam(value = "id") long personID) {
        Person deletedPerson = repository.findOne(personID);
        repository.delete(personID);
        return deletedPerson;
    }
}
