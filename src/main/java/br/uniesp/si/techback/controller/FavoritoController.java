package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Favorito;
import br.uniesp.si.techback.service.FavoritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/favoritos")
public class FavoritoController {

    private final FavoritoService favoritoService;

    public FavoritoController(FavoritoService favoritoService) {
        this.favoritoService = favoritoService;
    }

    @GetMapping
    public ResponseEntity<List<Favorito>> listarTodos() {
        return ResponseEntity.ok(favoritoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorito> buscarPorId(@PathVariable Long id) {
        Favorito favorito = favoritoService.buscarPorId(id);
        if (favorito != null) {
            return ResponseEntity.ok(favorito);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Favorito> salvar(@RequestBody Favorito favorito) {
        Favorito salvo = favoritoService.salvar(favorito);
        return ResponseEntity
                .created(URI.create("/favoritos/" + salvo.getId()))
                .body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Favorito> atualizar(@PathVariable Long id, @RequestBody Favorito favorito) {
        Favorito existente = favoritoService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        favorito.setId(id); // garante que atualiza o registro correto
        Favorito atualizado = favoritoService.salvar(favorito);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Favorito existente = favoritoService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        favoritoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
