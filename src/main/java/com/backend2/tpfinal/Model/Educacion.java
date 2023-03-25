
package com.backend2.tpfinal.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEdu; 
    private String descripcionEdu;
    private String aniosEdu;

    public Educacion() {
    }

    public Educacion(String nombreEdu, String descripcionEdu, String aniosEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.aniosEdu = aniosEdu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

    public String getAniosEdu() {
        return aniosEdu;
    }

    public void setAniosEdu(String añiosEdu) {
        this.aniosEdu = añiosEdu;
    }
    
    
    
}
