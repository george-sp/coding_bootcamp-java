package com.example.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Hello;

@RestController
public class HelloController {

	// produces = "application/json"
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public Hello sayHello() {
		return new Hello("world");
	}

	// curl -H "Content-Type: application/json" -X POST -d '{"to":"george-sp"}'
	// http://localhost:8080/hello
	@RequestMapping(path = "/hello", method = RequestMethod.POST, consumes = "application/json")
	public void putHello(@RequestBody Hello hello) {
		System.out.println(hello);
	}
}
