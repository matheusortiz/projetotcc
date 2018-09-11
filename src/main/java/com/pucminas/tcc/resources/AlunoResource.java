package com.pucminas.tcc.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pucminas.tcc.domain.Aluno;
import com.pucminas.tcc.services.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService svc;
	
	@RequestMapping(value="/{cpf}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String cpf) {
		Aluno obj = svc.buscar(cpf);
		return ResponseEntity.ok(obj);
	
	}

}
