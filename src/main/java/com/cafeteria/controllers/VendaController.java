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
import com.cafeteria.entities.Venda;
import com.cafeteria.entities.dtos.VendaDTO;
import com.cafeteria.services.ClienteService;
import com.cafeteria.services.ProdutoService;
import com.cafeteria.services.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {

	
	@Autowired
	private VendaService service;
	
	@Autowired
	private ClienteService CliService;
	
	@Autowired
	private ProdutoService ProService;
	
	@GetMapping
	public ResponseEntity<List<VendaDTO>> finAll() {
		List<Venda> list = service.findAll();
		List<VendaDTO> listDto = list.stream().map(x -> new VendaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<VendaDTO> findById(@PathVariable Long id){
		Venda venda = service.findById(id);
		VendaDTO vendaDto = new VendaDTO(venda);
		return ResponseEntity.ok().body(vendaDto);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Validated @RequestBody VendaDTO obj){
		Cliente cli = CliService.findById(obj.getId_cliente());
		Produto prod = ProService.findById(obj.getId_produto());
		Venda venda = new Venda(null, cli, prod, obj.getDt_venda());
		service.insert(venda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody VendaDTO obj) {
		Cliente cli = CliService.findById(obj.getId_cliente());
		Produto prod = ProService.findById(obj.getId_produto());
		Venda venda = new Venda(id, cli, prod, obj.getDt_venda());
		service.update(venda);
		return ResponseEntity.noContent().build();
	}
	
}
