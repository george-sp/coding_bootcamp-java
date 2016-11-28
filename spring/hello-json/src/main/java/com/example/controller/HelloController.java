package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Hello;

@RestController
public class HelloController {

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public Hello sayHello() {
		return new Hello("world");
	}
}
