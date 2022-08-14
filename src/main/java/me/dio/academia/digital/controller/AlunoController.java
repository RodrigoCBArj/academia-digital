package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping("/criar")
    public Aluno create(@Valid @RequestBody AlunoForm form) {
        return service.create(form);
    }

    @GetMapping("/{id}")
    public Aluno getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Aluno> getAll() {
        return service.getAll();
    }

    @PostMapping("/atualizar/{id}")
    public Aluno update(@Valid @PathVariable Long id, @RequestBody AlunoUpdateForm alunoUpdateForm) {
        return service.update(id, alunoUpdateForm);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}/avaliacoes")
    public List<AvaliacaoFisica> getAvaliacoes(@PathVariable Long id) {
        return service.getAvaliacoes(id);
    }
}
