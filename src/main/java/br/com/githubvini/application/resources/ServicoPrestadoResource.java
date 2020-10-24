package br.com.githubvini.application.resources;

import br.com.githubvini.application.model.entities.Cliente;
import br.com.githubvini.application.model.entities.ServicoPrestado;
import br.com.githubvini.application.model.entities.dto.ServicoPrestadoDTO;
import br.com.githubvini.application.repositories.ClienteRepository;
import br.com.githubvini.application.repositories.ServicoPrestadoRepository;
import br.com.githubvini.application.util.BigDecimalConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por ser o provedor e controlador ou resource da aplicação.
 * @Author: Vinicius Torres Pascucci.
 */
@RestController
@RequestMapping(value = "/api/servicos-prestados")
@CrossOrigin("http://localhost:4200")
public class ServicoPrestadoResource {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicoPrestadoRepository servicoPrestadoRepository;

    @Autowired
    private BigDecimalConverter convert;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado insert(@RequestBody ServicoPrestadoDTO dto) {

        LocalDate dataFormatt = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Cliente cliente =
                clienteRepository
                        .findById(idCliente)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente Inexistente"));


        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData( dataFormatt );
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor( convert.convert(dto.getPreco()) );

        return servicoPrestadoRepository.save(servicoPrestado);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ServicoPrestado> search( @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
                                         @RequestParam( value = "mes", required = false) Integer mes) {

        return servicoPrestadoRepository.findByNomeClienteAndMes("%" + nome + "%" , mes);
    }

}
