package com.example.model;

import javax.persistence.*;

@Entity
public class Todo {

    @ManyToOne
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    protected Todo() {

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