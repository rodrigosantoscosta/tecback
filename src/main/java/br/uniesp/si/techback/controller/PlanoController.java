package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Plano;
import br.uniesp.si.techback.service.PlanoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    private final PlanoService planoService;

    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }

    @GetMapping
    public List<Plano> listarTodos() {
        return planoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Plano buscarPorId(@PathVariable Long id) {
        return planoService.buscarPorId(id);
    }

    @PostMapping
    public Plano salvar(@RequestBody Plano plano) {
        return planoService.salvar(plano);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        planoService.deletar(id);
    }
}
