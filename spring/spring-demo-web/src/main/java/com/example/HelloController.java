package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
public class HelloController {

	@RequestMapping(path="/hello", method=RequestMethod.GET)
	public String sayHello() {
		return "Hello";
	}
	
	@RequestMapping(path="/george/hello", method=RequestMethod.GET)
	public String sayHelloGeorge() {
		return "Hello George!";
	}
}
