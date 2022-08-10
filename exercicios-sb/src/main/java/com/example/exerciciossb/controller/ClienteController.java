package com.example.exerciciossb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exerciciossb.models.entities.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@GetMapping(path = "/qualquer")
	public Cliente obeterCliente() {
		return new Cliente(1, "Zézé DiCamargo", "123.456.789-00");
	}
	
	@GetMapping("/{id}")
	public Cliente obeterCliente(@PathVariable int id) {
		return new Cliente(id, "Zézé DiCamargo", "123.456.789-00");
	}
	
	@GetMapping
	public Cliente obeterClientePorId(@RequestParam(name = "id") int id) {
		return new Cliente(id, "Pedrinho Algoz", "321.654.987-00");
	}
}
