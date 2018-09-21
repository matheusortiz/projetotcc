package com.pucminas.tcc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucminas.tcc.domain.Aluno;
import com.pucminas.tcc.repositories.AlunoRepository;
import com.pucminas.tcc.securities.UserSS;
import com.pucminas.tcc.services.exceptions.AuthorizationException;
import com.pucminas.tcc.services.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {
	
	/* classe de implementação dos serviços oferecidos ao aluno */
	
	@Autowired
	private AlunoRepository repo;
	private UserSS user;
	
	public Aluno buscar(String cpf) {
		Aluno obj = repo.findOne(cpf);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! CPF: " + cpf);
		}
		return obj;
	}
	
	public List<Aluno> findAll() {
		return repo.findAll();
	}

	public Aluno findByEmail(String email) {

		user = UserService.authenticated();
		if (user == null && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}

		Aluno obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + user.getCpf() + ", Tipo: " + Aluno.class.getName());
		}
		return obj;
	}

}
