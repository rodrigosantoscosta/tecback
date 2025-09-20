package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Endereco;
import br.uniesp.si.techback.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco buscarPorId(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        enderecoRepository.deleteById(id);
    }
}
