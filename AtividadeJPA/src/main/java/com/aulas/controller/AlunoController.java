package com.aulas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aulas.entidades.Aluno;
import com.aulas.repository.AlunoRepository;

@Controller
@RequestMapping("/")
public class AlunoController {
		
	@Autowired
	private AlunoRepository repo;
			
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/cadastro")
	public String formCadastro() {
		return "cadastro";
	}
	
	@GetMapping("/consulta")
	public String formConsulta(Model model) {
		Iterable<Aluno> alunos = repo.findAll();
		model.addAttribute("alunos", alunos);
		return "consulta";
	}
	
	@GetMapping("/consulta/{idaluno}")
	public String formEditar(@PathVariable("idaluno") int id, Model model) {
		Aluno aluno = repo.findById(id).get();
		model.addAttribute("aluno", aluno);
		return "edicao";
	}
	
	@PostMapping("/cadastro")
	public String salvar(Aluno aluno) {
		repo.save(aluno);
		return "redirect:/consulta";
	}
	
	@GetMapping("/delete/{idaluno}")
	public String delete(@PathVariable("idaluno") int id) {
		repo.deleteById(id);
		return "redirect:/consulta";
	}
}
