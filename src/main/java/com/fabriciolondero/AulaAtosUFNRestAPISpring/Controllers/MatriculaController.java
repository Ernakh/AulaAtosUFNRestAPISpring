package com.fabriciolondero.AulaAtosUFNRestAPISpring.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fabriciolondero.AulaAtosUFNRestAPISpring.Models.Aluno;
import com.fabriciolondero.AulaAtosUFNRestAPISpring.Models.Disciplina;
import com.fabriciolondero.AulaAtosUFNRestAPISpring.Models.Matricula;
import com.fabriciolondero.AulaAtosUFNRestAPISpring.Repositories.AlunoRepository;
import com.fabriciolondero.AulaAtosUFNRestAPISpring.Repositories.DisciplinaRepository;
import com.fabriciolondero.AulaAtosUFNRestAPISpring.Repositories.MatriculaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "Rest APIs Sistema de Matriculas")
@RestController
@RequestMapping("/matricula")
public class MatriculaController 
{
	@Autowired
	DisciplinaRepository disciplinaRepository;

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	MatriculaRepository matriculaRepository;
	
	@ApiOperation(value = "Retorna todos os Alunos", response = Iterable.class, tags = "matriculas")
	@GetMapping("/alunos")
	public List<Aluno> buscaAlunos()
	{
		return alunoRepository.findAll();
	}
	
	@ApiOperation(value = "Retorna todas as Disciplinas", response = Iterable.class, tags = "matriculas")
	@GetMapping("/disciplinas")
	public List<Disciplina> buscaDisciplinas()
	{
		return disciplinaRepository.findAll();
	}
	
	@ApiOperation(value = "Retorna todas as Matriculas", response = Iterable.class, tags = "matriculas")
	@GetMapping("/matriculas")
	public List<Matricula> buscaMatriculas() 
	{
		return matriculaRepository.findAll();
	}
	
	@ApiOperation(value = "Insere um Alunos", response = Iterable.class, tags = "matriculas")
	@PostMapping("/aluno")
	public Aluno add(@RequestBody Aluno aluno)
	{
		return alunoRepository.save(aluno);
	}
	
	@ApiOperation(value = "Insere uma Disciplina", response = Iterable.class, tags = "matriculas")
	@PostMapping("/disciplina")
	public Disciplina add(@RequestBody Disciplina disciplina)
	{
		return disciplinaRepository.save(disciplina);
	}
	
	@ApiOperation(value = "Retorna um Aluno pelo ID", response = Iterable.class, tags = "matriculas")
	@GetMapping("/aluno/{id}")
	public Optional<Aluno> getAluno(@PathVariable Long id)
	{
		return alunoRepository.findById(id);
	}
	
	@ApiOperation(value = "Retorna uma Disciplina pelo ID", response = Iterable.class, tags = "matriculas")
	@GetMapping("/disciplina/{id}")
	public Optional<Disciplina> getDisciplina(@PathVariable Long id)
	{
		return disciplinaRepository.findById(id);
	}
	
	@ApiOperation(value = "Grava uma matrícula", response = Iterable.class, tags = "matriculas")
	@PostMapping("/matricular")
	public Matricula add(@RequestParam Long idDisciplina, @RequestParam Long idAluno) 
	{
		try {

			Optional<Disciplina> disciplina = disciplinaRepository.findById(idDisciplina);

			Optional<Aluno> aluno = alunoRepository.findById(idAluno);

			Matricula matricula = new Matricula();
			matricula.setAluno(aluno.get());
			matricula.setDisciplina(disciplina.get());

			long vagas = disciplina.get().getVagas() 
					- matriculaRepository.countByDisciplina(disciplina.get());
			
			if(vagas == 0)
			{
				return null;
			}
			
			if(matriculaRepository.countByDisciplinaAndAluno(disciplina.get(), aluno.get()) > 0)
			{
				return null;
			}
			
			Matricula m = matriculaRepository.save(matricula);
			return m;

		} 
		catch (Exception e) 
		{
			return null;
		}
	}
}
