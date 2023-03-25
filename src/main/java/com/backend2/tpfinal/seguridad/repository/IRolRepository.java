
package com.backend2.tpfinal.seguridad.repository;

import com.backend2.tpfinal.seguridad.entity.Roll;
import com.backend2.tpfinal.seguridad.enums.RollNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository <Roll, Integer>{
    Optional<Roll> findByRolNombre(RollNombre rolnombre);
}
