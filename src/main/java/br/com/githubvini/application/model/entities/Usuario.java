package br.com.githubvini.application.model.entities;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Classe responsável por prover atributos do usuario.
 * @author Vinicius Torres Pascucci
 */
@Entity
public class Usuario {

    /**
     * Representa o identificador do usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Representa o cpf ( login ).
     */
    @Column(unique = true)
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    /**
     * Representa a senha.
     */
    @Column
    @NotEmpty(message = "{campo.senha.obrigatorio}")
    private String password;

    /**
     * Construtor default.
     */
    public Usuario() { }

    /**
     * Construtor com parâmetros.
     *
     * @param id - Integer - identificador usuario.
     * @param cpf - String - CPF usuario ( login ).
     * @param password - String - senha usuario.
     */
    public Usuario(Integer id, String cpf, String password) {
        this.id = id;
        this.cpf = cpf;
        this.password = password;
    }

    /**
     * Metodo get().
     * @return id - Integer - identificador usuario.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Metodo set().
     * @param id - Integer - identificador usuario.
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Metodo get().
     * @return cpf - String - cpf do usuario ( login ).
     */
    public String getCpf() {
        return this.cpf;
    }

    /**
     * Metodo set().
     * @param cpf - String - cpf do usuario ( login ).
     */
    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    /**
     * Metodo get().
     * @return password - String - senha do usuario.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Metodo set().
     * @param password - String - senha do usuario.
     */
    public void setPassword(final String password) {
        this.password = password;
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
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);
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
        return "Usuario{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
