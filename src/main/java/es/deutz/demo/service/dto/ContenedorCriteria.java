package es.deutz.demo.service.dto;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link es.deutz.demo.custom.domain.Contenedor} entity. This class is used
 * in {@link es.deutz.demo.web.rest.ContenedorResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /contenedors?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ContenedorCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter numerodepiezas;

    private StringFilter contenedor;

    private StringFilter articulo;

    public ContenedorCriteria(){
    }

    public ContenedorCriteria(ContenedorCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.numerodepiezas = other.numerodepiezas == null ? null : other.numerodepiezas.copy();
        this.contenedor = other.contenedor == null ? null : other.contenedor.copy();
        this.articulo = other.articulo == null ? null : other.articulo.copy();
    }

    @Override
    public ContenedorCriteria copy() {
        return new ContenedorCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getNumerodepiezas() {
        return numerodepiezas;
    }

    public void setNumerodepiezas(StringFilter numerodepiezas) {
        this.numerodepiezas = numerodepiezas;
    }

    public StringFilter getContenedor() {
        return contenedor;
    }

    public void setContenedor(StringFilter contenedor) {
        this.contenedor = contenedor;
    }

    public StringFilter getArticulo() {
        return articulo;
    }

    public void setArticulo(StringFilter articulo) {
        this.articulo = articulo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ContenedorCriteria that = (ContenedorCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(numerodepiezas, that.numerodepiezas) &&
            Objects.equals(contenedor, that.contenedor) &&
            Objects.equals(articulo, that.articulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        numerodepiezas,
        contenedor,
        articulo
        );
    }

    @Override
    public String toString() {
        return "ContenedorCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (numerodepiezas != null ? "numerodepiezas=" + numerodepiezas + ", " : "") +
                (contenedor != null ? "contenedor=" + contenedor + ", " : "") +
                (articulo != null ? "articulo=" + articulo + ", " : "") +
            "}";
    }

}
