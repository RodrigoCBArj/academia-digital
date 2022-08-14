package me.dio.academia.digital.entity.form;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
public class MatriculaForm {

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "O ID do aluno precisa ser positivo.")
  private Long alunoId;
}
