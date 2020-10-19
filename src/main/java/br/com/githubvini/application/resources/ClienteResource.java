package br.com.githubvini.application.resources;

import br.com.githubvini.application.model.entities.Cliente;
import br.com.githubvini.application.repositories.ClienteRepository;
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
@RequestMapping(value = "/api/clientes")
public class ClienteResource {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public Cliente findById( @PathVariable Integer id ) {
        return clienteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")
        );
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save( @Valid @RequestBody Cliente cliente ) {
        return clienteRepository.save(cliente);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @Valid @PathVariable Integer id, @RequestBody Cliente clienteAtualizado ) {
        clienteRepository
                .findById(id)
                .map(cliente -> {
                   cliente.setNome(clienteAtualizado.getNome());
                   cliente.setCpfCnpj(clienteAtualizado.getCpfCnpj());
                   return clienteRepository.save(cliente);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado" ) );
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
                 .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado, impossivel deletar") );
    }
}
