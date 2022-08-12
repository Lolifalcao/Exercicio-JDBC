package com.aulas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulas.entidades.Aluno;
import com.aulas.repository.AlunoRepository;

@RestController
@RequestMapping("/")
public class AlunoController {
	@Autowired
	AlunoRepository repo;
	
	@GetMapping("/alunos")
	public ResponseEntity<Iterable<Aluno>> getAlunos() {
		Iterable<Aluno> alunos = repo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(alunos);
	}
	
	@GetMapping("/alunos/{idaluno}")
	public ResponseEntity<Aluno> getAlunoById(@PathVariable("idaluno") Long idaluno) {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findById(idaluno).get());
	}
	
	@PostMapping("/alunos")
	public ResponseEntity<Aluno> saveAluno(@RequestBody Aluno aluno) {
		Aluno al = repo.save(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(al);
	}
	
	@DeleteMapping("/alunos/{idaluno}")
	public ResponseEntity<Void> deleteAluno(@PathVariable("idaluno") Long idaluno) {
		repo.deleteById(idaluno);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/alunos/{idaluno}")
	public ResponseEntity<Aluno> alteraAluno(@PathVariable("idaluno") Long idaluno, @RequestBody Aluno aluno) {
		return ResponseEntity.ok(repo.save(aluno));
	}
	
	
}
