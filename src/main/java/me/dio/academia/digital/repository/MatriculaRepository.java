package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    // o spring entende o que deve buscar quando denominamos o método de forma clara e objetiva:
    List<Matricula> findByAlunoBairro(String bairro);

    // com query jpql:
    @Query("SELECT m FROM Matricula m WHERE m.dataDaMatricula BETWEEN :dataInicial AND :dataFinal")
    // ou com query nativa:
//    @Query(value = "SELECT * FROM matriculas m WHERE m.data_da_matricula BETWEEN :dataInicial AND :dataFinal", nativeQuery = true)
    List<Matricula> findByDataDaMatriculaBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);
}
