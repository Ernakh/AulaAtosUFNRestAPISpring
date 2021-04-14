package com.fabriciolondero.AulaAtosUFNRestAPISpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabriciolondero.AulaAtosUFNRestAPISpring.Models.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>
{
	
}
