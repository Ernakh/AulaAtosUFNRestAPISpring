package com.fabriciolondero.AulaAtosUFNRestAPISpring.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{id}")
	public Optional<Pessoa> getPessoa(@PathVariable Long id)
	{
		return pessoaRepository.findById(id);
		//return pessoaRepository.getOne(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePessoa(@PathVariable Long id)
	{
		pessoaRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Pessoa updatePessoa(@RequestBody Pessoa pessoa, @PathVariable Long id)
	{
		Pessoa p = pessoaRepository.getOne(id);
		
		if(p == null)
		{
			return null;
		}
		
		p.setNome(pessoa.getNome());
		
		return pessoaRepository.save(p);
	}
}
