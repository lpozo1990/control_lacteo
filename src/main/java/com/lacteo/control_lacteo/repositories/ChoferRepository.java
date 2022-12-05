package com.lacteo.control_lacteo.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.lacteo.control_lacteo.Entities.Chofer;

public interface ChoferRepository extends JpaRepository<Chofer, Integer> {

@Query(value="SELECT nombre, apellidos FROM choferes", nativeQuery = true)
Object[] findNames();

@Modifying
@Transactional
@Query("UPDATE Chofer c SET c.nombre = :nombre, c.apellidos = :apellidos WHERE c.id = :id")
int updateChofer(@Param("id") int id, @Param("nombre") String nombre, @Param("apellidos") String apellidos);

Optional<Chofer> findById(Integer id);

}