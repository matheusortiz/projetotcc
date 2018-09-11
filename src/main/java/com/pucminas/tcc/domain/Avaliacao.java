package com.pucminas.tcc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Avaliacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer codigoAvaliacao;
	private String nome;
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="codigo_curso")
	private Curso curso;
	
	public Avaliacao() {
		
	}

	public Avaliacao(Integer codigoAvaliacao, String nome, Date data, Curso curso) {
		super();
		this.codigoAvaliacao = codigoAvaliacao;
		this.nome = nome;
		this.data = data;
		this.curso = curso;
	}



	public Integer getCodigoAvaliacao() {
		return codigoAvaliacao;
	}

	public void setCodigoAvaliacao(Integer codigoAvaliacao) {
		this.codigoAvaliacao = codigoAvaliacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoAvaliacao == null) ? 0 : codigoAvaliacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avaliacao other = (Avaliacao) obj;
		if (codigoAvaliacao == null) {
			if (other.codigoAvaliacao != null)
				return false;
		} else if (!codigoAvaliacao.equals(other.codigoAvaliacao))
			return false;
		return true;
	}
	
	

}
