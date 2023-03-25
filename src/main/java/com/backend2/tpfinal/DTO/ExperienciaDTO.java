
package com.backend2.tpfinal.DTO;

import javax.validation.constraints.NotBlank;


public class ExperienciaDTO {
    @NotBlank
    private String nombreE; 
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String aniosE;

    public ExperienciaDTO() {
    }

    public ExperienciaDTO(String nombreE, String descripcionE, String aniosE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.aniosE = aniosE;
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
