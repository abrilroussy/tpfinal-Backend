
package com.backend2.tpfinal.Controller;

import com.backend2.tpfinal.DTO.EducacionDTO;
import com.backend2.tpfinal.Model.Educacion;
import com.backend2.tpfinal.Service.EducacionService;
import com.backend2.tpfinal.seguridad.Controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin (origins = "https://frontend2-5828d.web.app/")
public class ControladoraEducacion {
    
    @Autowired
    EducacionService eduServ;
    
    @GetMapping ("edu/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = eduServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("edu/crear")
    public ResponseEntity<?> create(@RequestBody EducacionDTO dtoEdu) {
    if (StringUtils.isBlank(dtoEdu.getNombreEdu()))
        return new ResponseEntity (new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
    if(eduServ.existByNombreEdu(dtoEdu.getNombreEdu()))
        return new ResponseEntity(new Mensaje ("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
    
    Educacion edu = new Educacion (dtoEdu.getNombreEdu(),dtoEdu.getDescripcionEdu(), dtoEdu.getAniosEdu());
    eduServ.save(edu);
    
    return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("edu/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducacionDTO dtoEdu) {
        if (!eduServ.existById(id))
            return new ResponseEntity (new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if (!eduServ.existByNombreEdu(dtoEdu.getNombreEdu()) && eduServ.getByNombreEdu(dtoEdu.getNombreEdu()).get().getId() != id)
            return new ResponseEntity (new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtoEdu.getNombreEdu()))
            return new ResponseEntity (new Mensaje ("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion edu = eduServ.getOne(id).get();
        edu.setNombreEdu(dtoEdu.getNombreEdu());
        edu.setDescripcionEdu(dtoEdu.getDescripcionEdu());
        edu.setAniosEdu(dtoEdu.getAniosEdu());
        
        eduServ.save(edu);
        return new ResponseEntity(new Mensaje ("Educacion actualizada"), HttpStatus.OK);
        
    }
        
        @GetMapping("edu/detail/{id}")
        public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!eduServ.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = eduServ.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
        
        @DeleteMapping("edu/delete/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!eduServ.existById(id))
            return new ResponseEntity (new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        eduServ.delete(id);
        
        return new ResponseEntity (new Mensaje ("Educacion eliminada"), HttpStatus.OK);
    }
    
}
