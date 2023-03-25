package com.backend2.tpfinal.Service;

import com.backend2.tpfinal.Model.Educacion;
import com.backend2.tpfinal.Repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {

    @Autowired
    EducacionRepository eduRepo;

    public List<Educacion> list() {
        return eduRepo.findAll();
    }

    public Optional<Educacion> getOne(int id) {
        return eduRepo.findById(id);
    }

    public Optional<Educacion> getByNombreEdu(String nombreEdu) {
        return eduRepo.findByNombreEdu(nombreEdu);
    }

    public void save(Educacion edu) {
        eduRepo.save(edu);
    }

    public void delete(int id) {
        eduRepo.deleteById(id);
    }

    public boolean existById(int id) {
        return eduRepo.existsById(id);
    }

    public boolean existByNombreEdu(String nombreEdu) {
        return eduRepo.existsByNombreEdu(nombreEdu);
    }

}