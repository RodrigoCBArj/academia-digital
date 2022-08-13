package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @GetMapping
    public List<Aluno> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Aluno getById(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping("/criar")
    public Aluno create(@RequestBody AlunoForm form) {
        return service.create(form);
    }

    @PostMapping("/atualizar/{id}")
    public Aluno update(@PathVariable Long id, @RequestBody AlunoUpdateForm alunoUpdateForm) {
        return service.update(id, alunoUpdateForm);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
