package com.example.exerciciossb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	
	@GetMapping("/somar/{a}/{b}")
	public int somar(@PathVariable int a,@PathVariable int b) {
		return a + b;
	}
	
	@GetMapping("/subtrair")
	public int subtrair(@RequestParam(required = true, name = "a", defaultValue = "1") int a, @RequestParam(name = "b", defaultValue = "5", required = false) int b) {
		return a - b;
	}
	
}
