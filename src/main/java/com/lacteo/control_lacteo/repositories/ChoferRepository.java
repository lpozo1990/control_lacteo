package com.lacteo.control_lacteo.repositories;

import org.springframework.data.jpa.repository.*;

import com.lacteo.control_lacteo.Entities.Chofer;

public interface ChoferRepository extends JpaRepository<Chofer, Integer> {

@Query(value="SELECT nombre, apellidos FROM choferes", nativeQuery = true)
Object[] findNames();
}