package me.dio.academia.digital.entity.form;

import lombok.Getter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
public class AvaliacaoFisicaUpdateForm {

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "'${validatedValue}' precisa ser positivo.")
  private double peso;

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "'${validatedValue}' precisa ser positivo.")
  @DecimalMin(value = "150", message = "'${validatedValue}' precisa ser no mínimo {value}.")
  private double altura;
}
