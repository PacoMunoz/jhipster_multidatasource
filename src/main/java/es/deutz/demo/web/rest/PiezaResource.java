package es.deutz.demo.web.rest;

import es.deutz.demo.custom.domain.Pieza;
import es.deutz.demo.service.PiezaQueryService;
import es.deutz.demo.service.PiezaService;
import es.deutz.demo.service.dto.PiezaCriteria;
import es.deutz.demo.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link Pieza}.
 */
@RestController
@RequestMapping("/api")
public class PiezaResource {

    private final Logger log = LoggerFactory.getLogger(PiezaResource.class);

    private static final String ENTITY_NAME = "pieza";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PiezaService piezaService;

    private final PiezaQueryService piezaQueryService;

    public PiezaResource(PiezaService piezaService, PiezaQueryService piezaQueryService) {
        this.piezaService = piezaService;
        this.piezaQueryService = piezaQueryService;
    }

    /**
     * {@code POST  /piezas} : Create a new pieza.
     *
     * @param pieza the pieza to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new pieza, or with status {@code 400 (Bad Request)} if the pieza has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/piezas")
    public ResponseEntity<Pieza> createPieza(@RequestBody Pieza pieza) throws URISyntaxException {
        log.debug("REST request to save Pieza : {}", pieza);
        if (pieza.getId() != null) {
            throw new BadRequestAlertException("A new pieza cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Pieza result = piezaService.save(pieza);
        return ResponseEntity.created(new URI("/api/piezas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /piezas} : Updates an existing pieza.
     *
     * @param pieza the pieza to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pieza,
     * or with status {@code 400 (Bad Request)} if the pieza is not valid,
     * or with status {@code 500 (Internal Server Error)} if the pieza couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/piezas")
    public ResponseEntity<Pieza> updatePieza(@RequestBody Pieza pieza) throws URISyntaxException {
        log.debug("REST request to update Pieza : {}", pieza);
        if (pieza.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Pieza result = piezaService.save(pieza);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, pieza.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /piezas} : get all the piezas.
     *

     * @param pageable the pagination information.

     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of piezas in body.
     */
    @GetMapping("/piezas")
    public ResponseEntity<List<Pieza>> getAllPiezas(PiezaCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Piezas by criteria: {}", criteria);
        Page<Pieza> page = piezaQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * {@code GET  /piezas/count} : count all the piezas.
    *
    * @param criteria the criteria which the requested entities should match.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
    */
    @GetMapping("/piezas/count")
    public ResponseEntity<Long> countPiezas(PiezaCriteria criteria) {
        log.debug("REST request to count Piezas by criteria: {}", criteria);
        return ResponseEntity.ok().body(piezaQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /piezas/:id} : get the "id" pieza.
     *
     * @param id the id of the pieza to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pieza, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/piezas/{id}")
    public ResponseEntity<Pieza> getPieza(@PathVariable Long id) {
        log.debug("REST request to get Pieza : {}", id);
        Optional<Pieza> pieza = piezaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(pieza);
    }

    /**
     * {@code DELETE  /piezas/:id} : delete the "id" pieza.
     *
     * @param id the id of the pieza to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/piezas/{id}")
    public ResponseEntity<Void> deletePieza(@PathVariable Long id) {
        log.debug("REST request to delete Pieza : {}", id);
        piezaService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
