package es.deutz.demo.custom.repository;

import es.deutz.demo.custom.domain.Pieza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Pieza entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PiezaRepository extends JpaRepository<Pieza, Long>, JpaSpecificationExecutor<Pieza> {

}
