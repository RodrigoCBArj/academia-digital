package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    /*
    * @param dataDeNascimento: data de nascimento dos alunos
    * @return lista com todos os alunos que possuem a data de nascimento informada
    */
    List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);
}
