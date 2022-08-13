package me.dio.academia.digital.entity.form;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AlunoForm {

  private String nome;

  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;
}
