package br.com.githubvini.application.model.entities.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Classe responsável por trafegar apenas os atrivutos que precisamos.
 * @author Vinicius Torres Pascucci.
 */
public class ServicoPrestadoDTO {

    /**
     * Representa a descrição do serviço.
     */
    private String descricao;

    /**
     * Representa o valor do servço.
     */
    private String preco;

    /**
     * Representa a data do serviiço prestado.
     */
    private String data;

    /**
     * Representa o id do cliente.
     */
    private Integer idCliente;

    /**
     * Construtor Padrão.
     */
    public ServicoPrestadoDTO() { }

    /**
     * Construtor com parâmetros.
     *
     * @param descricao - String - descrição do serviço.
     * @param preco - String - preço do serviço.
     * @param data - String - data do serviço prestado.
     * @param idCliente - Integer - identificador do cliente.
     */
    public ServicoPrestadoDTO(String descricao, String preco, String data, Integer idCliente) {
        this.descricao = descricao;
        this.preco = preco;
        this.data = data;
        this.idCliente = idCliente;
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
     * @param descricao - String - descrição do serviço.
     */
    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    /**
     * Metodo get().
     * @return preco - String - preço do serviço.
     */
    public String getPreco() {
        return this.preco;
    }

    /**
     * Metodo set().
     * @param preco - String - preço do serviço.
     */
    public void setPreco(final String preco) {
        this.preco = preco;
    }

    /**
     * Metodo get().
     * @return data - String - data do serviço prestado.
     */
    public String getData() {
        return this.data;
    }

    /**
     * Metodo set().
     * @param data - String - data do serviço prestado.
     */
    public void setData(final String data) {
        this.data = data;
    }

    /**
     * Metodo get().
     * @return idCliente - Integer - identificador do cliente.
     */
    public Integer getIdCliente() {
        return this.idCliente;
    }

    /**
     * Metodo set().
     * @param idCliente - Integer - identificador do cliente.
     */
    public void setIdCliente(final Integer idCliente) {
        this.idCliente = idCliente;
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
        ServicoPrestadoDTO that = (ServicoPrestadoDTO) o;
        return idCliente.equals(that.idCliente);
    }

    /**
     * Metodo hashCode to make a hash for id.
     * @return id.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idCliente);
    }

    @Override
    public String toString() {
        return "ServicoPrestadoDTO{" +
                "descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", data='" + data + '\'' +
                ", idCliente=" + idCliente +
                '}';
    }
}
