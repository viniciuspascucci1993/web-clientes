package br.com.githubvini.application.resources.exception;

import java.util.Arrays;
import java.util.List;

/**
 * Classe responsável por fornecer os erros da API.
 * @Author: Vinicius Torres Pascucci.
 */
public class ApiErrors {
    /**
     * Representa uma lista de erros.
     */
    private List<String> errors;

    /**
     * Metodo get().
     * @return errors - List<String> - errors.
     */
    public List<String> getErrors() {
        return this.errors;
    }

    /**
     * Metodo set().
     * @param errors - List<String> - errors.
     */
    public void setErrors(final List<String> errors) {
        this.errors = errors;
    }

    /**
     * Construtor com uma lista de parâmetros.
     * @param errors - List<String> - errors.
     */
    public ApiErrors( List<String> errors) {
        this.errors = errors;
    }

    /**
     * Construtor passando apenas uma string de mensagem.
     * @param message - String - message
     */
    public ApiErrors(String message) {
        this.errors = Arrays.asList(message);
    }

}

