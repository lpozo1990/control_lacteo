package com.lacteo.control_lacteo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lacteo.control_lacteo.Entities.Registro;

public interface RegistroRepository extends CrudRepository<Registro, Integer> {
    Iterable<Registro> findAllByYear(Integer year);

    @Query(value = "SELECT DISTINCT year FROM registros;", nativeQuery = true)
    List<Integer> getAllYears();

}
