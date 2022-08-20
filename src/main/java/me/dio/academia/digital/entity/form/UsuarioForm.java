package me.dio.academia.digital.entity.form;

import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
public class UsuarioForm {

  @NotBlank(message = "Preencha o campo corretamente.")
  @Size(min = 3, max = 15, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String username;

  @NotBlank(message = "Preencha o campo corretamente.")
  @Size(min = 3, max = 50, message = "Sua senha precisa conter de {min} a {max} caracteres.")
  private String password;
}
