package br.com.githubvini.application.resources;

import br.com.githubvini.application.model.entities.Usuario;
import br.com.githubvini.application.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Classe responsável por ser o provedor e controlador ou resource da aplicação.
 * @Author: Vinicius Torres Pascucci.
 */
@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody @Valid Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
