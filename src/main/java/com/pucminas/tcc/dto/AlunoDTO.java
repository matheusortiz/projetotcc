package com.pucminas.tcc.dto;

import java.io.Serializable;

import com.pucminas.tcc.domain.Aluno;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cpf, nome, endereco, municipio, estado, telefone, email, senha;

	public AlunoDTO (){
		
	}
	
	public AlunoDTO(Aluno a) {
		super();
		cpf = a.getCpf();
		nome = a.getNome();
		endereco = a.getEndereco();
		municipio = a.getMunicipio();
		estado = a.getEstado();
		telefone = a.getTelefone();
		email = a.getEmail();
		senha = a.getSenha();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
}
