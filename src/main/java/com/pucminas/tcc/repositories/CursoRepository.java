package com.pucminas.tcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pucminas.tcc.domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
