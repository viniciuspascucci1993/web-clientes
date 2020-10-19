package br.com.githubvini.application.resources;

import br.com.githubvini.application.model.entities.Cliente;
import br.com.githubvini.application.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Classe responsável por ser o provedor e controlador da aplicação.
 * @Author: Vinicius Torres Pascucci.
 */
@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save( @RequestBody Cliente cliente ) {
        return clienteRepository.save(cliente);
    }
}
