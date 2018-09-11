package com.pucminas.tcc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucminas.tcc.domain.Aluno;
import com.pucminas.tcc.repositories.AlunoRepository;
import com.pucminas.tcc.services.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repo;
	
	public Aluno buscar(String cpf) {
		Aluno obj = repo.findOne(cpf);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! CPF: " + cpf);
		}
		return obj;
	}

}
