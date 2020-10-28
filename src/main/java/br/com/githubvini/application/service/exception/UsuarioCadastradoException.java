package br.com.githubvini.application.service.exception;

import br.com.githubvini.application.model.entities.Usuario;

/**
 * Classe de eror para usuario já cadastrado.
 * @author Vinicius Torres Pascucci.
 */
public class UsuarioCadastradoException extends RuntimeException {

    public UsuarioCadastradoException( String cpf ) {
        super("CPF já existente na base de dados para cadastro." + cpf);
    }
}
