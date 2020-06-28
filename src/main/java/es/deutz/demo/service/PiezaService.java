package es.deutz.demo.service;

import es.deutz.demo.custom.domain.Pieza;
import es.deutz.demo.custom.repository.PiezaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Pieza}.
 */
@Service
@Transactional
public class PiezaService {

    private final Logger log = LoggerFactory.getLogger(PiezaService.class);

    private final PiezaRepository piezaRepository;

    public PiezaService(PiezaRepository piezaRepository) {
        this.piezaRepository = piezaRepository;
    }

    /**
     * Save a pieza.
     *
     * @param pieza the entity to save.
     * @return the persisted entity.
     */
    public Pieza save(Pieza pieza) {
        log.debug("Request to save Pieza : {}", pieza);
        return piezaRepository.save(pieza);
    }

    /**
     * Get all the piezas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Pieza> findAll(Pageable pageable) {
        log.debug("Request to get all Piezas");
        return piezaRepository.findAll(pageable);
    }


    /**
     * Get one pieza by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Pieza> findOne(Long id) {
        log.debug("Request to get Pieza : {}", id);
        return piezaRepository.findById(id);
    }

    /**
     * Delete the pieza by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Pieza : {}", id);
        piezaRepository.deleteById(id);
    }
}
