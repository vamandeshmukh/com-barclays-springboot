package com.barclays.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		System.out.println("hello");
		return "Hello world!";
	}

	@GetMapping("/hi")
	public String hi() {
		System.out.println("hi");
		return "Hi! How're you?";
	}
}
