package com.example.exerciciossb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {

//	@RequestMapping(method = RequestMethod.GET, path = "/olaMundo")//da pra fazer dessa forma ou
	@GetMapping(path = /* "/olaMundo" */ { "/olaMundo", "/helloWorld" })
//	@PostMapping
//	@PutMapping
	public String olaMundo() {
		return "Olá Mundo!!!";
	}
}
