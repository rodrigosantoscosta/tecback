package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Endereco;
import br.uniesp.si.techback.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<Endereco> listarTodos() {
        return enderecoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Endereco buscarPorId(@PathVariable Long id) {
        return enderecoService.buscarPorId(id);
    }

    @PostMapping
    public Endereco salvar(@RequestBody Endereco endereco) {
        return enderecoService.salvar(endereco);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        enderecoService.deletar(id);
    }
}
