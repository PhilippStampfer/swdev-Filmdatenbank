/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.swdev.filme;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author dev
 */
@Entity
public class Filme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int jahr;
    @ManyToOne
    private Schauspieler schauspieler;
    @ManyToOne
    private Regisseure regisseure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filme)) {
            return false;
        }
        Filme other = (Filme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", name=" + name + ", jahr=" + jahr + ", schauspieler=" + schauspieler + ", regisseure=" + regisseure + '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    public Schauspieler getSchauspieler() {
        return schauspieler;
    }

    public void setSchauspieler(Schauspieler schauspieler) {
        this.schauspieler = schauspieler;
    }

    public Regisseure getRegisseure() {
        return regisseure;
    }

    public void setRegisseure(Regisseure regisseure) {
        this.regisseure = regisseure;
    }
    
}
