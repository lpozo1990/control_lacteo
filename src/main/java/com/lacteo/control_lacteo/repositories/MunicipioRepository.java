package com.lacteo.control_lacteo.repositories;
import org.springframework.data.jpa.repository.*;

import com.lacteo.control_lacteo.Entities.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {
    Municipio findByNombre(String nombre);
}
