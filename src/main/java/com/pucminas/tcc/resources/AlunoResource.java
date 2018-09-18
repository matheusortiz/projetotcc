package com.pucminas.tcc.resources;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pucminas.tcc.domain.Aluno;
import com.pucminas.tcc.dto.AlunoDTO;
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
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AlunoDTO>> findAll() {
		List<Aluno> list = svc.findAll();
		List<AlunoDTO> listDto = list.stream().map(obj -> new AlunoDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	

	@RequestMapping(value="/email", method=RequestMethod.GET)
	public ResponseEntity<Aluno> findByEmail(@RequestParam(value="value") String email) {
		Aluno obj = svc.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}

}
