package com.fabriciolondero.AulaAtosUFNRestAPISpring.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fabriciolondero.AulaAtosUFNRestAPISpring.Models.Pessoa;
import com.fabriciolondero.AulaAtosUFNRestAPISpring.Repositories.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController 
{
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<Pessoa> getPessoas()
	{
		return pessoaRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa adicionar(@RequestBody Pessoa pessoa)
	{
		return pessoaRepository.save(pessoa);
	}
}
