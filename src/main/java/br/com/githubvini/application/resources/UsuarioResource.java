package br.com.githubvini.application.resources;

import br.com.githubvini.application.model.entities.Usuario;
import br.com.githubvini.application.repositories.UsuarioRepository;
import br.com.githubvini.application.service.UserService;
import br.com.githubvini.application.service.exception.UsuarioCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

/**
 * Classe responsável por ser o provedor e controlador ou resource da aplicação.
 * @Author: Vinicius Torres Pascucci.
 */
@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody @Valid Usuario usuario) {
        try {
            userService.insert(usuario);
        } catch (UsuarioCadastradoException ex) {
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, ex.getMessage() );
        }

    }
}
