package com.cafeteria.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cafeteria.entities.Cliente;
import com.cafeteria.entities.Produto;
import com.cafeteria.entities.dtos.ProdutoDTO;
import com.cafeteria.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> finAll() {
		List<Produto> list = service.findAll();
		List<ProdutoDTO> listDto = list.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id){
		Produto prod = service.findById(id);		
		ProdutoDTO prodDto = new ProdutoDTO(prod);
		return ResponseEntity.ok().body(prodDto);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Validated @RequestBody Produto obj){
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Produto obj) {
		service.update(id, obj);
		return ResponseEntity.noContent().build();
	}
	
}
