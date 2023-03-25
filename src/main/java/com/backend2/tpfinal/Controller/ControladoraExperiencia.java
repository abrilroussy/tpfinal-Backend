
package com.backend2.tpfinal.Controller;

import com.backend2.tpfinal.DTO.ExperienciaDTO;
import com.backend2.tpfinal.Model.Experiencia;
import com.backend2.tpfinal.Service.ExperienciaService;
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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin (origins = "https://frontend2-5828d.web.app/")
public class ControladoraExperiencia {
    @Autowired 
    ExperienciaService expServ;
    
    @GetMapping ("exp/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = expServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("exp/crear")
    public ResponseEntity<?> create(@RequestBody ExperienciaDTO dtoExp) {
    if (StringUtils.isBlank(dtoExp.getNombreE()))
        return new ResponseEntity (new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
    if(expServ.existByNombreE(dtoExp.getNombreE()))
        return new ResponseEntity(new Mensaje ("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
    
    Experiencia exp = new Experiencia (dtoExp.getNombreE(),dtoExp.getDescripcionE(), dtoExp.getAniosE());
    expServ.save(exp);
    
    return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("exp/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDTO dtoExp) {
        if (!expServ.existById(id))
            return new ResponseEntity (new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if (!expServ.existByNombreE(dtoExp.getNombreE()) && expServ.getByNombreE(dtoExp.getNombreE()).get().getId() != id)
            return new ResponseEntity (new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtoExp.getNombreE()))
            return new ResponseEntity (new Mensaje ("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia exp = expServ.getOne(id).get();
        exp.setNombreE(dtoExp.getNombreE());
        exp.setDescripcionE(dtoExp.getDescripcionE());
        exp.setAniosE(dtoExp.getAniosE());
        
        expServ.save(exp);
        return new ResponseEntity(new Mensaje ("Experiencia actualizada"), HttpStatus.OK);
    }
    @GetMapping("exp/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!expServ.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = expServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("exp/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!expServ.existById(id))
            return new ResponseEntity (new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        expServ.delete(id);
        
        return new ResponseEntity (new Mensaje ("Experiencia eliminada"), HttpStatus.OK);
    }
    
    
}
