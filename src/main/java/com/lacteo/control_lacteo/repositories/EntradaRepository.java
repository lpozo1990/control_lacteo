package com.lacteo.control_lacteo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lacteo.control_lacteo.Entities.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
    
}
