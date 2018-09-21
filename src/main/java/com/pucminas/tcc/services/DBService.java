package com.pucminas.tcc.services;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pucminas.tcc.domain.Aluno;
import com.pucminas.tcc.domain.Avaliacao;
import com.pucminas.tcc.domain.Curso;
import com.pucminas.tcc.repositories.AlunoRepository;
import com.pucminas.tcc.repositories.AvaliacaoRepository;
import com.pucminas.tcc.repositories.CursoRepository;

@Service
public class DBService {
	
	/* classe para povoar o banco de dados em ambiente de testes e desenvolvimento */
	
	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	
	public void instantiateTestDataBase() {
		
		
		Aluno a1 = new Aluno("01119076080", "Matheus Ortiz", "Rua Severino", "União da Vitória", "PR", "(42)99953-6507", "matheus7@gmail.com", pe.encode("1234"));
		Aluno a2 = new Aluno("111", "Luana Rodrigues", "Rua Barão", "União da Vitória", "PR", "(42)99900-3021", "luana.rodrigues@outlook.com", pe.encode("1234"));
		Aluno a3 = new Aluno("11122233344", "Professor da PUC Minas", "PUC Minas", "Belo Horizonte", "MG", "(37)3352-2600", "p@p.com", pe.encode("p"));
		
		alunoRepository.save(Arrays.asList(a1, a2, a3));
		
		Date d = new Date(2017/12/12);
		
		
		Curso c1 = new Curso(null, "Engenharia de Software", "2017/2");
		Curso c2 = new Curso(null, "Ciência da Computação", "2017/2");
		
		Avaliacao ava1 = new Avaliacao(null, "Prova presencial ES", d, c1);
		Avaliacao ava2 = new Avaliacao(null, "Prova online CC", d, c2);
		Avaliacao ava3 = new Avaliacao(null, "Prova presencial CC", d, c2);
		
		c1.getAvaliacoes().addAll(Arrays.asList(ava1));
		c2.getAvaliacoes().addAll(Arrays.asList(ava2, ava3));
		
		cursoRepository.save(Arrays.asList(c1,c2));
		avaliacaoRepository.save(Arrays.asList(ava1,ava2, ava3));
		
		
		
	}
}
