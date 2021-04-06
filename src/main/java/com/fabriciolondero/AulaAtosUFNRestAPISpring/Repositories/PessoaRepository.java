package com.fabriciolondero.AulaAtosUFNRestAPISpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabriciolondero.AulaAtosUFNRestAPISpring.Models.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>
{
	
}
