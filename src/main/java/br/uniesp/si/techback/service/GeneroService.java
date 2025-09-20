package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Genero;
import br.uniesp.si.techback.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<Genero> listarTodos() {
        return generoRepository.findAll();
    }

    public Genero salvar(Genero genero) {
        return generoRepository.save(genero);
    }

    public Genero buscarPorId(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        generoRepository.deleteById(id);
    }
}
