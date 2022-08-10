package com.example.exerciciossb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exerciciossb.models.entities.Carro;
import com.example.exerciciossb.models.repositories.CarroRepository;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

	@Autowired
	public CarroRepository carroRepository;
	
	@PostMapping
	public Carro criarCarro(@RequestParam String nome) {
		Carro car = new Carro(nome);
		carroRepository.save(car);
		return car;
	}
}
