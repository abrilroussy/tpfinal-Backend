
package com.backend2.tpfinal.Service;

import com.backend2.tpfinal.Model.Persona;
import java.util.List;


public interface IPersonaService {
     public List <Persona> verPersonas (long par); 
     
     public void crearPersona (Persona pers);
     
     public void borrarPersona (Long id);
     
     public Persona buscarPersona(Long id);
}
