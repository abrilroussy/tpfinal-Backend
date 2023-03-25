
package com.backend2.tpfinal.seguridad.entity;

import com.backend2.tpfinal.seguridad.enums.RollNombre;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Roll {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    @Enumerated(EnumType.STRING)
    private RollNombre rolNombre;

    public Roll() {
    }

    public Roll(int id, RollNombre rolNombre) {
        this.id = id;
        this.rolNombre = rolNombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RollNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RollNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    
}
