package com.example.controller;

import com.example.dao.PersonDAO;
import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/findByName/{firstName}")
    public Iterable<Person> getByName(@PathVariable String firstName) {
        return repository.findByName(firstName);
    }

    @RequestMapping(value = "/findByNameOrSurname/{nameOrSurname}")
    public Iterable<Person> getByNameOrSurname(@PathVariable String nameOrSurname) {
        return repository.findByNameOrSurname(nameOrSurname, nameOrSurname);
    }

    @GetMapping(value = "/countByName/{firstName}")
    public long getNumberOfName(@PathVariable String firstName) {
        return repository.countByName(firstName);
    }

    @GetMapping(value = "/countByLastName/{lastName}")
    public long getNumberOfSurname(@PathVariable String lastName) {
        return repository.countByLastName(lastName);
    }

    @RequestMapping(value = "/saveOne")
    public Person createOne(@RequestParam(value = "id") long personID, @RequestParam(value = "name") String personName, @RequestParam(value = "surname", required = false) String personSurname) {
        return repository.save(new Person(personID, personName, personSurname));
    }

    @RequestMapping(value = "/deleteOne")
    public Person deleteOne(@RequestParam(value = "id") long personID) {
        Person deletedPerson = repository.findOne(personID);
        repository.delete(personID);
        return deletedPerson;
    }
}
