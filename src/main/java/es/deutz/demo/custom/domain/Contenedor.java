package es.deutz.demo.custom.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Contenedor.
 */
@Entity
@Table(name = "contenedor")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Contenedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numerodepiezas")
    private String numerodepiezas;

    @Column(name = "contenedor")
    private String contenedor;

    @Column(name = "articulo")
    private String articulo;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumerodepiezas() {
        return numerodepiezas;
    }

    public Contenedor numerodepiezas(String numerodepiezas) {
        this.numerodepiezas = numerodepiezas;
        return this;
    }

    public void setNumerodepiezas(String numerodepiezas) {
        this.numerodepiezas = numerodepiezas;
    }

    public String getContenedor() {
        return contenedor;
    }

    public Contenedor contenedor(String contenedor) {
        this.contenedor = contenedor;
        return this;
    }

    public void setContenedor(String contenedor) {
        this.contenedor = contenedor;
    }

    public String getArticulo() {
        return articulo;
    }

    public Contenedor articulo(String articulo) {
        this.articulo = articulo;
        return this;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Contenedor)) {
            return false;
        }
        return id != null && id.equals(((Contenedor) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Contenedor{" +
            "id=" + getId() +
            ", numerodepiezas='" + getNumerodepiezas() + "'" +
            ", contenedor=" + getContenedor() +
            ", articulo='" + getArticulo() + "'" +
            "}";
    }
}
