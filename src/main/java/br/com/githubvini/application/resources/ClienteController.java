package br.com.githubvini.application.resources;

import br.com.githubvini.application.model.entities.Cliente;
import br.com.githubvini.application.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * Classe responsável por ser o provedor e controlador da aplicação.
 * @Author: Vinicius Torres Pascucci.
 */
@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public Cliente findById( @PathVariable Integer id ) {
        return clienteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save( @RequestBody Cliente cliente ) {
        return clienteRepository.save(cliente);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ) {
        clienteRepository
                 .findById(id)
                 .map(cliente -> {
                     clienteRepository.delete(cliente);
                     return Void.TYPE;
                 })
                 .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
    }
}
