/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend2.tpfinal.DTO;

import jakarta.validation.constraints.NotBlank;


public class EducacionDTO {
    @NotBlank
    private String nombreEdu; 
    @NotBlank
    private String descripcionEdu;
    @NotBlank
    private String aniosEdu;

    public EducacionDTO() {
    }

    public EducacionDTO(String nombreEdu, String descripcionEdu, String aniosEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.aniosEdu = aniosEdu;
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

    public void setAniosEdu(String aniosEdu) {
        this.aniosEdu = aniosEdu;
    }
    
    
}
