package es.deutz.demo.service.dto;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link es.deutz.demo.custom.domain.Pieza} entity. This class is used
 * in {@link es.deutz.demo.web.rest.PiezaResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /piezas?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class PiezaCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter datamatrix;

    private StringFilter serie;

    public PiezaCriteria(){
    }

    public PiezaCriteria(PiezaCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.datamatrix = other.datamatrix == null ? null : other.datamatrix.copy();
        this.serie = other.serie == null ? null : other.serie.copy();
    }

    @Override
    public PiezaCriteria copy() {
        return new PiezaCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getDatamatrix() {
        return datamatrix;
    }

    public void setDatamatrix(StringFilter datamatrix) {
        this.datamatrix = datamatrix;
    }

    public StringFilter getSerie() {
        return serie;
    }

    public void setSerie(StringFilter serie) {
        this.serie = serie;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PiezaCriteria that = (PiezaCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(datamatrix, that.datamatrix) &&
            Objects.equals(serie, that.serie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        datamatrix,
        serie
        );
    }

    @Override
    public String toString() {
        return "PiezaCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (datamatrix != null ? "datamatrix=" + datamatrix + ", " : "") +
                (serie != null ? "serie=" + serie + ", " : "") +
            "}";
    }

}
