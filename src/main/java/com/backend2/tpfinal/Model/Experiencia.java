
package com.backend2.tpfinal.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    private String nombreE;
    private String descripcionE; 
    private String aniosE;

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, String aniosE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.aniosE = aniosE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getAniosE() {
        return aniosE;
    }

    public void setAniosE(String aniosE) {
        this.aniosE = aniosE;
    }
    
    
    
}
