package com.lacteo.control_lacteo.repositories;


import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lacteo.control_lacteo.Entities.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
    @Modifying
    @Transactional
    @Query(value="UPDATE entradas set nombre_del_chofer = ?3, ruta = ?5  cantidad_leche = ?2 , fecha = ?4 WHERE id = ?1", nativeQuery= true)
    void updateEntrada(Integer id,Integer cantidadDeLeche,  String nombre, Date fecha, String ruta);
}
