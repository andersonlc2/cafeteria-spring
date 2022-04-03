package com.cafeteria.entities.dtos;

import java.io.Serializable;
import java.util.Date;

import com.cafeteria.entities.Cliente;

public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String documento;
	private String email;
	private String telefone;
	private Date dt_cadastro;
	
	public ClienteDTO() {
		
	}

	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.documento = obj.getDocumento();
		this.email = obj.getEmail();
		this.telefone = obj.getTelefone();
		this.dt_cadastro = obj.getDt_cadastro();
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(Date dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}
	
	
	
}
