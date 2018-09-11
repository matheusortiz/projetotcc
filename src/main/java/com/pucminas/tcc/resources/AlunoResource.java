package com.pucminas.tcc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pucminas.tcc.domain.Aluno;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Aluno> listar() {
		
		Aluno a1 = new Aluno("011.190.760-80", "Mateus", "Rua Severino, 141", "UVA", "PR", "(42)99953-6507", "matheus7@gmail.com", "123");
		Aluno a2 = new Aluno("111.222.333-00", "Luana", "Rua Barão, 343", "UVA", "PR", "(42)99900-3021", "luana.rodrigues@outlook.com", "123");
		
		List<Aluno> lista = new ArrayList<>();
		lista.add(a1);
		lista.add(a2);
		
		return lista;
	}

}
