package com.cafeteria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeteria.entities.Venda;
import com.cafeteria.repositories.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repo;
	
	
	public Venda findById(Long id) {
		return repo.findById(id).get();
	}

	
	public List<Venda> findAll(){
		return repo.findAll();
	}
	
	
	public Venda insert(Venda obj) {
		repo.save(obj);
		return obj;
	}
	
	
	public Venda update(Venda obj) {
		Venda venda = repo.findById(obj.getId()).get();
		venda.setCliente(obj.getCliente());
		venda.setProduto(obj.getProduto());
		venda.setDt_venda(obj.getDt_venda());
		repo.save(venda);
		return venda;
	}
	
	public void delete(Long id) {
		Venda cli = repo.findById(id).get();
		repo.delete(cli);
	}
	
}
