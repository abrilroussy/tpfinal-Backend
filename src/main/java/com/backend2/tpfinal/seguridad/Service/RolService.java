
package com.backend2.tpfinal.seguridad.Service;

import com.backend2.tpfinal.seguridad.entity.Roll;
import com.backend2.tpfinal.seguridad.enums.RollNombre;
import com.backend2.tpfinal.seguridad.repository.IRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository iRolRepository;
    
    public Optional<Roll> getByRollNombre (RollNombre rolNombre) {
        return iRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Roll rol) {
        iRolRepository.save(rol);
    }
}
