package com.cafeteria.entities.dtos;

import java.io.Serializable;
import java.util.Date;

import com.cafeteria.entities.Venda;

public class VendaDTO implements Serializable{

	private static final long serialVersionUID = 1L;


	private Long id;
	private Long id_cliente;
	private Long id_produto;
	private Date dt_venda;
	
	public VendaDTO() {
		
	}

	public VendaDTO(Venda obj) {
		this.id = obj.getId();
		this.id_cliente = obj.getCliente().getId();
		this.id_produto = obj.getProduto().getId();
		this.dt_venda = obj.getDt_venda();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Long getId_produto() {
		return id_produto;
	}

	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}

	public Date getDt_venda() {
		return dt_venda;
	}

	public void setDt_venda(Date dt_venda) {
		this.dt_venda = dt_venda;
	}
	
}
