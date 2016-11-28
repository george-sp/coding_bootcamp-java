package com.example.model;

public class Hello {

	private String to;

	public Hello() {
		this.to = "world";
	}

	public Hello(String to) {
		this.to = to;
	}

	public String getTo() {
		return to;
	}

	@Override
	public String toString() {
		return this.to;
	}
}
