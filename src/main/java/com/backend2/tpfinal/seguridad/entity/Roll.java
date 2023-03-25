
package com.backend2.tpfinal.seguridad.entity;

import com.backend2.tpfinal.seguridad.enums.RollNombre;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
