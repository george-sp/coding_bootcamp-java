package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TodoList")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// @Column(name="xxx")
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
}
