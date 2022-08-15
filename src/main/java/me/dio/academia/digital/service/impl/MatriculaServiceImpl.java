package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        matricula.setAluno(alunoRepository.getById(form.getAlunoId()));

        return repository.save(matricula);
    }

    @Override
    public Matricula getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if (bairro == null) return repository.findAll();
        else return repository.findByAlunoBairro(bairro);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Matricula> findByDataDaMatriculaBetween(@RequestParam Map<String,String> requestParams) {
        String dataInicial = requestParams.get("dataInicial");
        String dataFinal = requestParams.get("dataFinal");

        LocalDateTime dataInicialFormatted = LocalDateTime.parse(dataInicial, JavaTimeUtils.LOCAL_DATE_TIME_FORMATTER);
        LocalDateTime dataFinalFormatted = LocalDateTime.parse(dataFinal, JavaTimeUtils.LOCAL_DATE_TIME_FORMATTER);

        return repository.findByDataDaMatriculaBetween(dataInicialFormatted, dataFinalFormatted);
    }
}
