package com.cafeteria.entities.dtos;

import java.io.Serializable;

import com.cafeteria.entities.Produto;

public class ProdutoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String descricao;
	private double valor;
	private String categoria;
	
	public ProdutoDTO() {
		
	}

	public ProdutoDTO(Produto obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
		this.valor = obj.getValor();
		this.categoria = obj.getCategoria();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
