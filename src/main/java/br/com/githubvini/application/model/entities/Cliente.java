package br.com.githubvini.application.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Classe de entidade chamada Cliente.
 * @Author: Vinicius Torres Pascucci.
 */
@Entity
public class Cliente {

    /**
     * Representa o identificador do cliente.
     */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    /**
     * Represemta o nome do cliente.
     */
    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    /**
     * Representa o cpf ou do cliente.
     */
    @Column(nullable = false, length = 14)
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    /**
     * Representa d data de cadastro desse cliente.
     */
    @Column(name = "data_cadastro")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersistDate() {
        setDataCadastro(LocalDate.now());
    }

    /**
     * Construtor default
     */
    public Cliente() { }

    /**
     * Construtor com parâmetros.
     * @param id - Integer - identificador cliente.
     * @param nome - String - nome do cliente.
     * @param cpf - String - CPF do cliente.
     * @param dataCadastro - LocalDate - data de caddastro desse cliente.
     */
    public Cliente(Integer id, String nome, String cpf, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
    }

    /**
     * Metodo get().
     * @return id - Integer - identificador cliente.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Metodo set().
     * @param id - Integer - identificador cliente.
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Metodo get().
     * @return nome - String - nome do cliente.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Metodo set().
     * @param nome - String - nome do cliente.
     */
    public void setNome(final String nome) {
        this.nome = nome;
    }

    /**
     * Metodo get().
     * @return cpf - String - cpf do cliente.
     */
    public String getCpf() {
        return this.cpf;
    }

    /**
     * Metodo set().
     * @param cpf - String - cpf do cliente.
     */
    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    /**
     * Metodo get().
     * @return dataCadastro - LocalDate - data de cadastro desse cliente.
     */
    public LocalDate getDataCadastro() {
        return this.dataCadastro;
    }

    /**
     * Metodo set().
     * @param dataCadastro - LocalDate - data de cadastro desse cliente.
     */
    public void setDataCadastro(final LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * Metodo equals to compare only by id.
     * @param o
     * @return id.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    /**
     * Metodo hashCode to make a hash for id.
     * @return id.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "IDENTIFICADOR CLIENTE: " + id + '\n' +
                "NOME CLIENTE: " + nome + '\'' +
                "CPF DO CLIENTE: " + cpf + '\'' +
                "DATA DE CADASTRO DO CLIENTE: " + dataCadastro +
                '}';
    }
}
