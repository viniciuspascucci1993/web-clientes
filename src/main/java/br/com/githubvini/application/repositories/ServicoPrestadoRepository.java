package br.com.githubvini.application.repositories;

import br.com.githubvini.application.model.entities.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * interface para nossos repositórios JPA.
 * @Author: Vinicius Torres Pascucci.
 */
@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {

    @Query("SELECT s FROM ServicoPrestado s JOIN s.cliente c WHERE UPPER( c.nome ) LIKE UPPER( :nome ) and MONTH( s.data ) =:mes  ")
    List<ServicoPrestado> findByNomeClienteAndMes(@Param("nome") String nome,
                                                  @Param("mes") Integer mes);
}
