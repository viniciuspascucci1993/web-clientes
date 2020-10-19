package br.com.githubvini.application.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Classe de entidade chamada ServicoPrestado.
 * @Author: Vinicius Torres Pascucci.
 */
@Entity
public class ServicoPrestado {

    /**
     * Representa o identificador do servico prestado.
     */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    /**
     * Representa a descrição do serviço.
     */
    @Column(nullable = false, length = 255)
    private String descricao;

    /**
     * Represente o cliente para qual o serviço foi prestado.
     */
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    /**
     * Representa o valor do serviço.
     */
    private BigDecimal valor;

    /**
     * Construtor padrão.
     */
    public ServicoPrestado() { }

    /**
     * Construtor com parâmetros.
     * @param id - Integer - identificador do serviço.
     * @param descricao - String - descrição do serviço.
     * @param cliente - Cliente - cliente.
     * @param valor - BigDecimal - valor do serviço.
     */
    public ServicoPrestado(Integer id, String descricao, Cliente cliente, BigDecimal valor) {
        this.id = id;
        this.descricao = descricao;
        this.cliente = cliente;
        this.valor = valor;
    }

    /**
     * Metodo get().
     * @return id - Integer - identificador do serviço.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Metodo set().
     * @param id - Integer - identificador do serviço.
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Metodo get().
     * @return descricao - String - descrição do serviço.
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Metodo set().
     * @param descricao String - descrição do serviço.
     */
    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    /**
     * Metodo get().
     * @return cliente - Cliente - cliente para qual o serviço foi prestado.
     */
    public Cliente getCliente() {
        return this.cliente;
    }

    /**
     * Metodo set().
     * @param cliente - Cliente - cliente para qual o serviço foi prestado.
     */
    public void setCliente(final Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Metodo get().
     * @return valor - BigDecimal - valor do serviço.
     */
    public BigDecimal getValor() {
        return this.valor;
    }

    /**
     * Metodo set().
     * @param valor - BigDecimal - valor do serviço.
     */
    public void setValor(final BigDecimal valor) {
        this.valor = valor;
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
        ServicoPrestado that = (ServicoPrestado) o;
        return id.equals(that.id);
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
        return "ServicoPrestado{" +
                "IDENTIFICADOR SERVIÇO PRESTADO: " + id + '\n'+
                "DESCRIÇÃO DO SERVIÇO: " + descricao + '\'' +
                "CLIENTE: " + cliente + '\n' +
                "VALOR DO SERVIÇO: " + valor + '\n' +
                '}';
    }
}
