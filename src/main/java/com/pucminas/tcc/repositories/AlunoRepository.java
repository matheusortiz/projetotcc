package com.pucminas.tcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pucminas.tcc.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String>{

}
