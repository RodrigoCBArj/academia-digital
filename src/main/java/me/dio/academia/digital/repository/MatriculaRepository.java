package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    // o spring entende o que deve buscar quando denominamos o método de forma clara e objetiva:
    List<Matricula> findByAlunoBairro(String bairro);
}
