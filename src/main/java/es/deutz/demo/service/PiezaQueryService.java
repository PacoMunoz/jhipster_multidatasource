package es.deutz.demo.service;

import es.deutz.demo.custom.domain.Pieza;
import es.deutz.demo.custom.domain.Pieza_;
import es.deutz.demo.custom.repository.PiezaRepository;
import es.deutz.demo.service.dto.PiezaCriteria;
import io.github.jhipster.service.QueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for executing complex queries for {@link Pieza} entities in the database.
 * The main input is a {@link PiezaCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Pieza} or a {@link Page} of {@link Pieza} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PiezaQueryService extends QueryService<Pieza> {

    private final Logger log = LoggerFactory.getLogger(PiezaQueryService.class);

    private final PiezaRepository piezaRepository;

    public PiezaQueryService(PiezaRepository piezaRepository) {
        this.piezaRepository = piezaRepository;
    }

    /**
     * Return a {@link List} of {@link Pieza} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Pieza> findByCriteria(PiezaCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Pieza> specification = createSpecification(criteria);
        return piezaRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Pieza} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Pieza> findByCriteria(PiezaCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Pieza> specification = createSpecification(criteria);
        return piezaRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PiezaCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Pieza> specification = createSpecification(criteria);
        return piezaRepository.count(specification);
    }

    /**
     * Function to convert {@link PiezaCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Pieza> createSpecification(PiezaCriteria criteria) {
        Specification<Pieza> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Pieza_.id));
            }
            if (criteria.getDatamatrix() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDatamatrix(), Pieza_.datamatrix));
            }
            if (criteria.getSerie() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSerie(), Pieza_.serie));
            }
        }
        return specification;
    }
}
