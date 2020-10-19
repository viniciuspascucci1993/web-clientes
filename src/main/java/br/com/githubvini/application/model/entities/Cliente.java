package br.com.githubvini.application.model.entities;

import javax.persistence.*;
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
    private String nome;

    /**
     * Representa o cpf ou cnpj do cliente.
     */
    @Column(nullable = false, length = 11)
    private String cpfCnpj;

    /**
     * Representa d data de cadastro desse cliente.
     */
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    /**
     * Construtor default
     */
    public Cliente() { }

    /**
     * Construtor com parâmetros.
     * @param id - Integer - identificador cliente.
     * @param nome - String - nome do cliente.
     * @param cpfCnpj - String - CPF/CNPJ do cliente.
     * @param dataCadastro - LocalDate - data de caddastro desse cliente.
     */
    public Cliente(Integer id, String nome, String cpfCnpj, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
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
     * @return cpfCnpj - String - cpf ou cnpj do cliente.
     */
    public String getCpfCnpj() {
        return this.cpfCnpj;
    }

    /**
     * Metodo set().
     * @param cpfCnpj - String - cpf ou cnpj do cliente.
     */
    public void setCpfCnpj(final String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
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
                "CPF OU CNPJ DO CLIENTE: " + cpfCnpj + '\'' +
                "DATA DE CADASTRO DO CLIENTE: " + dataCadastro +
                '}';
    }
}
