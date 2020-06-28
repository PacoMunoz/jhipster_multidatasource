package es.deutz.demo.custom.repository;

import es.deutz.demo.custom.domain.Contenedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Contenedor entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ContenedorRepository extends JpaRepository<Contenedor, Long>, JpaSpecificationExecutor<Contenedor> {

}
