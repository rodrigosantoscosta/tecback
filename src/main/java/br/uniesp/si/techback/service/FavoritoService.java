package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Favorito;
import br.uniesp.si.techback.repository.FavoritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoService {

    private final FavoritoRepository favoritoRepository;

    public FavoritoService(FavoritoRepository favoritoRepository) {
        this.favoritoRepository = favoritoRepository;
    }

    public List<Favorito> listarTodos() {
        return favoritoRepository.findAll();
    }

    public Favorito salvar(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    public Favorito buscarPorId(Long id) {
        return favoritoRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        favoritoRepository.deleteById(id);
    }
}
