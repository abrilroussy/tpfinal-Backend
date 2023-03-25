package com.backend2.tpfinal.Controller;

import com.backend2.tpfinal.Model.Persona;
import com.backend2.tpfinal.Service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://frontend2-5828d.web.app/")
public class Controladora {

    @Autowired
    private IPersonaService persoServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("persona/new")
    public String agregarPersona(@RequestBody Persona pers) {
        persoServ.crearPersona(pers);
        return "La persona fue creada correctamente";
    }

    @GetMapping("persona/ver")
    @ResponseBody
    public List<Persona> verPersonas() {
        return persoServ.verPersonas((long) 1);
    } 

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("persona/delete/{id}")
    public void borrarPersona(@PathVariable Long id) {
        persoServ.borrarPersona(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("persona/editar/{id}")
    public Persona editarPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevaImg,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("header") String nuevoHeader,
            @RequestParam("descripcion") String nuevaDescripcion) {
        Persona persona = persoServ.buscarPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevaImg);
        persona.setTitulo(nuevoTitulo);
        persona.setHeader(nuevoHeader);
        persona.setDescripcion(nuevaDescripcion);

        persoServ.crearPersona(persona);
        return persona;

    }

}
