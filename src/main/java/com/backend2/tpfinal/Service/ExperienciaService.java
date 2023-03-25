
package com.backend2.tpfinal.Service;

import com.backend2.tpfinal.Model.Experiencia;
import com.backend2.tpfinal.Repository.ExperienciaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    ExperienciaRepository expRepo;
    
    public List<Experiencia> list() {
        return expRepo.findAll();
    }
    
    public Optional<Experiencia> getOne(int id) {
        return expRepo.findById(id);
    }
    
    public Optional<Experiencia> getByNombreE(String nombreE){
        return expRepo.findByNombreE(nombreE);
    }
    
    public void save(Experiencia exp){
        expRepo.save(exp);
    }
    
    public void delete(int id) {
        expRepo.deleteById(id);
    }
    
    public boolean existById(int id) {
        return expRepo.existsById(id);
    }
    
    public boolean existByNombreE (String nombreE) {
        return expRepo.existsByNombreE(nombreE);
    }
}