package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository afRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica af = new AvaliacaoFisica();
        af.setAluno(alunoRepository.getById(form.getAlunoId()));
        af.setPeso(form.getPeso());
        af.setAltura(form.getAltura());

        return afRepository.save(af);
    }

    @Override
    public AvaliacaoFisica getById(Long id) {
        return afRepository.getById(id);
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return afRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica af = afRepository.getById(id);
        af.setPeso(formUpdate.getPeso());
        af.setAltura(formUpdate.getAltura());

        return afRepository.save(af);
    }

    @Override
    public void delete(Long id) {
        afRepository.deleteById(id);
    }
}
