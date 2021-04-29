package br.com.zupacademy.Mercadolivre.teste;

import br.com.zupacademy.Mercadolivre.usuario.Usuario;
import br.com.zupacademy.Mercadolivre.usuario.UsuarioRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("testes")
public class UsuarioLogadoController {

    private UsuarioRepository repository;

    public UsuarioLogadoController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Usuario getUsuario(Principal principal){

        Optional<Usuario> usuarioOptional = repository.findByEmail(principal.getName());

        if(usuarioOptional.isPresent()){
            return usuarioOptional.get();
        }

        throw new RuntimeException("Usuario Inválido");

    }

}
