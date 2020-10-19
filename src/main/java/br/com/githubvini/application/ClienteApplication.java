package br.com.githubvini.application;

import br.com.githubvini.application.model.entities.Cliente;
import br.com.githubvini.application.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * Classe Inicial do Spring boot para rodar a Aplicação.
 * @Author: Vinicius Torres Pascucci.
 */
@SpringBootApplication
public class ClienteApplication {

    @Autowired
    private ClienteRepository clienteRepository;

    @Bean
    public CommandLineRunner runDatas() {

        return args -> {
            Cliente cliente = new Cliente();
            cliente.setCpfCnpj("235.255.478-55");
            cliente.setNome("Vinicius Torres Pascucci");

            clienteRepository.save(cliente);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ClienteApplication.class, args);
    }
}
