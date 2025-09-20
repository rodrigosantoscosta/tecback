package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Plano;
import br.uniesp.si.techback.repository.PlanoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoService {

    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public List<Plano> listarTodos() {
        return planoRepository.findAll();
    }

    public Plano salvar(Plano plano) {
        return planoRepository.save(plano);
    }

    public Plano buscarPorId(Long id) {
        return planoRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        planoRepository.deleteById(id);
    }
}
