package br.com.githubvini.application.repositories;

import br.com.githubvini.application.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * interface para nossos repositórios JPA.
 * @Author: Vinicius Torres Pascucci.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByCpf( String cpf);
}
