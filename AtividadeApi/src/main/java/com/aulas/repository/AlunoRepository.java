package com.aulas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aulas.entidades.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {

}
