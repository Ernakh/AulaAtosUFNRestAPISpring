package com.fabriciolondero.AulaAtosUFNRestAPISpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabriciolondero.AulaAtosUFNRestAPISpring.Models.Aluno;
import com.fabriciolondero.AulaAtosUFNRestAPISpring.Models.Disciplina;
import com.fabriciolondero.AulaAtosUFNRestAPISpring.Models.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>
{
	public long countByDisciplina(Disciplina disciplina);
	
	public long countByDisciplinaAndAluno(Disciplina disciplina, Aluno aluno);
}
