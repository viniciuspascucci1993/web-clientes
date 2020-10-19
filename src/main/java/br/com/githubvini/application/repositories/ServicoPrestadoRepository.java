package br.com.githubvini.application.repositories;

import br.com.githubvini.application.model.entities.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * interface para nossos repositórios JPA.
 * @Author: Vinicius Torres Pascucci.
 */
@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {
}
