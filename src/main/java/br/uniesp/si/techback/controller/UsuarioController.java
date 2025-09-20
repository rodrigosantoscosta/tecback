package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        usuarioService.criarUsuario(usuario);
        return usuario;
    }

    @GetMapping
    public List<Usuario> listarTodosUsuarios() {
        return usuarioService.listarTodosUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .orElse(null); // retorna null caso não encontre
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.atualizarId(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuarioPorId(id);
    }
}
