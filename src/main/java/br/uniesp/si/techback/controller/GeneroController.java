package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Genero;
import br.uniesp.si.techback.service.GeneroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @GetMapping
    public List<Genero> listarTodos() {
        return generoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Genero buscarPorId(@PathVariable Long id) {
        return generoService.buscarPorId(id);
    }

    @PostMapping
    public Genero salvar(@RequestBody Genero genero) {
        return generoService.salvar(genero);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        generoService.deletar(id);
    }
}
