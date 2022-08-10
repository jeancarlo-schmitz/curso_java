package com.example.exerciciossb.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exerciciossb.models.entities.Produto;
import com.example.exerciciossb.models.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping // ou tbm dá pra aglutinar junto com o @PutMapping
//	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	

//	@GetMapping
//	public Iterable<Produto> obterProdutos(){
//		return produtoRepository.findAll();
//	}
	
	@GetMapping("/pagina/{numeroPagina}")
	public Iterable<Produto> obterProdutos(@PathVariable int numeroPagina){
		PageRequest page = PageRequest.of(numeroPagina, 2);
		return produtoRepository.findAll(page);
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> obterProdutosPorId(@PathVariable int id){
		return produtoRepository.findById(id);
	}
	
	@GetMapping("/nome/{nome}")
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String nome){
		return produtoRepository.searchByName(nome);
	}
	
	@PutMapping
	public Produto alterarProduto(Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	@DeleteMapping("/{id}")
	public void deletarProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}
}
