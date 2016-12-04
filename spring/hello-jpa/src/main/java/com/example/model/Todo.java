package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String text;

	@ManyToOne
	private Person person;

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