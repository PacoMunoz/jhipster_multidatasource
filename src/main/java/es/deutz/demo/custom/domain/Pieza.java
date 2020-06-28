package es.deutz.demo.custom.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Pieza.
 */
@Entity
@Table(name = "pieza")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Pieza implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datamatrix")
    private String datamatrix;

    @Column(name = "serie")
    private String serie;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatamatrix() {
        return datamatrix;
    }

    public Pieza datamatrix(String datamatrix) {
        this.datamatrix = datamatrix;
        return this;
    }

    public void setDatamatrix(String datamatrix) {
        this.datamatrix = datamatrix;
    }

    public String getSerie() {
        return serie;
    }

    public Pieza serie(String serie) {
        this.serie = serie;
        return this;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pieza)) {
            return false;
        }
        return id != null && id.equals(((Pieza) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Pieza{" +
            "id=" + getId() +
            ", datamatrix='" + getDatamatrix() + "'" +
            ", serie='" + getSerie() + "'" +

            "}";
    }
}

