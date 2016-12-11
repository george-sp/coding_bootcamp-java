package com.example.model;

import javax.persistence.*;

@Entity
public class Todo {

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    protected Todo() {

    }

    public Todo(String text) {
        this.text = text;
    }

    public Todo(String text, long personID) {
        this.text = text;
        this.person = new Person(personID);
    }

    public Todo(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public Person getPerson() {
        return this.person;
    }
}