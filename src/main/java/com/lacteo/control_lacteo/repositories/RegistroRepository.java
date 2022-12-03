package com.lacteo.control_lacteo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.lacteo.control_lacteo.Entities.Registro;

public interface RegistroRepository extends CrudRepository<Registro, Integer> {
    Iterable<Registro> findAllByYear(Integer year);

    @Query(value = "SELECT DISTINCT year FROM registros;", nativeQuery = true)
    List<Integer> getAllYears();


    @Transactional
    @Modifying
    @Query(value="INSERT INTO registros  (id, mes, year, cantidad_de_leche) VALUES (?1, ?2, ?3, ?4)  ON DUPLICATE KEY UPDATE cantidad_de_leche = cantidad_de_leche + ?4", nativeQuery = true)
    void saveNew(Integer id, String mes, Integer year, Integer cantidadDeLeche);

}
