package com.fabriciolondero.AulaAtosUFNRestAPISpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabriciolondero.AulaAtosUFNRestAPISpring.Models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>
{
	
}
