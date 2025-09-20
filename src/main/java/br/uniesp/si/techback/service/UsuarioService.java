package br.uniesp.si.techback.service;

import br.uniesp.si.techback.exception.EntidadeNaoEncontradaException;
import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public void criarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodosUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }


    @Transactional
    public Usuario atualizarId(Long id, Usuario usuario) {
        // Verifica se o usuario existe
        if (!usuarioRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("usuario n o encontrado com o ID: " + id);
        }

        // Atualiza o ID do usuario para o valor recebido
        usuario.setId(id);

        // Salva o usuario atualizado
        return usuarioRepository.save(usuario);
    }

    /**
     * Exclui um usuario existente.
     *
     * @param id o ID do usuario a ser exclu do.
     * @throws EntidadeNaoEncontradaException se o usuario n o existir.
     */
    @Transactional
    public void excluirUsuarioPorId(Long id) {
        // Verifica se o usuario existe
        if (!usuarioRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("usuario n o encontrado com o ID: " + id);
        }

        // Exclui o usuario
        usuarioRepository.deleteById(id);
    }
}
